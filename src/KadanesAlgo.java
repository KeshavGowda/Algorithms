
public class KadanesAlgo {

	public static int kadanesAlgorithm(int[] array) {
		int max = array[0];
		int currMax = array[0];
		for (int i = 1; i < array.length; i++) {
			currMax = Math.max(array[i], currMax + array[i]);
			max = Math.max(max, currMax);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
		System.out.println(kadanesAlgorithm(arr));
	}

}
