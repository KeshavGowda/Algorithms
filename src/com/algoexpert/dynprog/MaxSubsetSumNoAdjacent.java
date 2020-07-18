package com.algoexpert.dynprog;

public class MaxSubsetSumNoAdjacent {
	
	public static void main(String[] args) {
		int[] arr = new int[] {75, 105, 120, 75, 90, 135};
		int[] arr2 = new int[] {18, 15, 11, 10};
		int[] arr3 = new int[] {1, 15, 3};
		System.out.println(maxSubsetSumNoAdjacent(arr3));
	}

	public static int maxSubsetSumNoAdjacent(int[] array) {
		int[] sums = new int[array.length];
		if (array.length == 1) 
			return array[0];
		if (array.length == 2)
			return 0;
		for (int i = 0; i < array.length; i++) {
			if (i <= 1) {
				sums[i] = array[i];
			} else {
				int adj1 = array[i] + sums[i - 2];
				int adj2 = 0;
				if (i - 3 >= 0)
					adj2 = array[i] + sums[i - 3];
				sums[i] = Math.max(adj1, adj2);
			}
		}
		return Math.max(sums[sums.length - 1], sums[sums.length - 2]);
	}

}
