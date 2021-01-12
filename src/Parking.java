import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Parking {
	
	private static class ParkingCar {
		int start;
		int end;
		ParkingCar(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	private static class CompareCar implements Comparator<ParkingCar> {

		@Override
		public int compare(ParkingCar o1, ParkingCar o2) {
			if (o1.start < o2.start) 
				return -1;
			else if (o1.start == o2.start)
				return 0;
			else
				return 1;
		}
		
	}

	static int minParkingSpaces(int[][] parkingStartEndTimes) {
		// YOUR CODE HERE
		int minSpaces = 0; 
		List<ParkingCar> slots = new ArrayList<>();
		List<ParkingCar> cars = sortParkingCars(parkingStartEndTimes);
		slots.add(cars.get(0));
		minSpaces++;
		for (int i = 1; i < cars.size(); i++) {
			ParkingCar newcar = cars.get(i);
			int slotNo = checkForOpenSlot(slots, newcar);
			if (slotNo == -1) {
				slots.add(newcar);
				minSpaces++;
			} else {
				slots.remove(slotNo);
				slots.add(newcar);
			}
		}
		return minSpaces;
	}
	
	private static int checkForOpenSlot(List<ParkingCar> slots, ParkingCar newcar) {
		for (int i = 0; i < slots.size(); i++) {
			ParkingCar car = slots.get(i);
			if (car.end <= newcar.start)
				return i;
		}
		return -1;
	}
	
	private static List<ParkingCar> sortParkingCars(int[][] parkingStartEndTimes) {
		List<ParkingCar> cars = new ArrayList<>();
		for (int i = 0; i < parkingStartEndTimes.length; i++) {
			ParkingCar car = new ParkingCar(parkingStartEndTimes[i][0], parkingStartEndTimes[i][1]);
			cars.add(car);
		}
		Collections.sort(cars, new CompareCar());
		return cars;
	}
	

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}

}
