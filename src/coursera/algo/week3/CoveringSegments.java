package coursera.algo.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoveringSegments {

    private static List<Integer> optimalPoints(List<Segment> segments) {
    	List<Integer> points = new ArrayList<>();
    	List<Segment> toBeRemoved = new ArrayList<>();
    	while(segments.size() > 0) {
    		int min_right = min_right(segments);
    		points.add(min_right);
    		for(int i = 0; i < segments.size(); i++) {
    			if(include_point(segments.get(i), min_right)) {
    				toBeRemoved.add(segments.get(i));
    			}
    		}
    		segments.removeAll(toBeRemoved);
    		toBeRemoved.clear();
    	}
        return points;
    }
    
    private static boolean include_point(Segment segment, int min_right) {
    	if(min_right <= segment.end && min_right >= segment.start)
    		return true;
    	else 
    		return false;
    }
    
    private static int min_right(List<Segment> segments) {
    	int min_right = segments.get(0).end;
    	for(int i = 1; i < segments.size(); i++) {
    		if(segments.get(i).end < min_right)
    			min_right = segments.get(i).end;
    	}
    	return min_right;
    }

    private static class Segment implements Comparable<Segment>{
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

		@Override
		public int compareTo(Segment o) {
			if (this.start >= o.start)
				return 1;
			else
				return -1;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Segment) {
				Segment a = (Segment)obj;
				if(this.start == a.start && this.end == a.end)
					return true;
			}
			return false;
		}
		
		@Override
		public String toString() {
			return new String("("+this.start+","+this.end+")");
		}
		
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //Segment[] segments = new Segment[n];
        List<Segment> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            //segments[i] = new Segment(start, end);
            segments.add(new Segment(start, end));
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }

}
 
