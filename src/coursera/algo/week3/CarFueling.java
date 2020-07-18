package coursera.algo.week3;

public class CarFueling {
	
	 private static int computeMinRefills(int dist, int tank, int[] stops) {
		 int distCov = 0; int numRefils = 0; int distCovOld;
		 int tank_rem = tank;
		 if(distCov + tank >= dist) 
			 return numRefils;
		 int i = 0;
		 while(i < stops.length) {
			 distCovOld = distCov;
			 while(i < stops.length && stops[i] - distCov <= tank_rem) {
				 tank_rem = tank_rem - (stops[i] - distCov); 
				 distCov = stops[i];
				 i++;
			 }
			 if(distCovOld == distCov)
				 return -1;
			 if(i <= stops.length) {
				 numRefils++;
				 tank_rem = tank;
			 }
		 }
		 if(dist - distCov <= tank_rem) 
			 return numRefils;
		 else
			 return -1;
	 }
	
	public static void main(String[] args) {
		int[] stops = {200, 375, 550, 750};
		int[] stops2 = {100, 200, 300, 400};
		int[] stops3 = {1, 2, 5, 9};
		int[] stops4 = {100, 150};
		System.out.println(computeMinRefills(10, 3, stops3));
	}

}