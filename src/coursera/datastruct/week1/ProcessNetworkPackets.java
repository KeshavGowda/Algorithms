package coursera.datastruct.week1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ProcessNetworkPackets {
	
	private static int buffer_size;
	private static Queue<Request> buffer = new LinkedList<>();
	
	static class Request {
		int id;
		int arrival_time;
		int process_time;
		
		public Request(int id, int arrival_time, int process_time) {
			this.id = id;
			this.arrival_time = arrival_time;
			this.process_time = process_time;
		}
	}
	
	static class Response implements Comparable<Response> {
		int id;
		boolean isDropped;
	    int start_time;
		
	    public Response(int id, boolean isDropped, int start_time) {
	    	this.id = id;
	        this.isDropped = isDropped;
	        this.start_time = start_time;
	    }

		@Override
		public int compareTo(Response o) {
			if(this.id > o.id)
				return 1;
			else
				return -1;
		}
	}
	
	private static void processRequests(Queue<Request> incoming_requests) {
		List<Response> responses = new LinkedList<>();
		for(int i = 0; i < buffer_size; i++) {
			buffer.add(incoming_requests.poll());
		}
		int time = buffer.peek().arrival_time;
		while(!buffer.isEmpty()) {
			Request request = buffer.peek();
			Response response;
			if(request.arrival_time > time)
				response = new Response(request.id, false, request.arrival_time);
			else
				response = new Response(request.id, false, time);
			responses.add(response);
			time += request.process_time;
			while(!incoming_requests.isEmpty()) {
				Request nextRequest = incoming_requests.peek();
				if(nextRequest.arrival_time >= time) {
					buffer.add(incoming_requests.poll());
					break;
				}
				else if(nextRequest.arrival_time < time || buffer.size() == buffer_size) {
					responses.add(new Response(incoming_requests.poll().id, true, -1));
				} 
			}
			buffer.poll();
		}
		printResponses(responses);	
	}
	
	private static void printResponses(List<Response> responses) {
		responses.stream().sorted().forEach(resp -> System.out.println(resp.start_time));
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		buffer_size = scanner.nextInt();
		Queue<Request> incoming_requests = new LinkedList<>();
		int requests_count = scanner.nextInt();
		for(int i = 0; i < requests_count; i++) {
			int arrival_time = scanner.nextInt();
            int process_time = scanner.nextInt();
            incoming_requests.add(new Request(i, arrival_time, process_time));
		}
		scanner.close();
		if(incoming_requests.isEmpty())
			return;
		processRequests(incoming_requests);
		
	}

}
