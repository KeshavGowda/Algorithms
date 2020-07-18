package com.algoexpert.dynprog;

import java.util.Arrays;

public class MinJumps {

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3 };
		System.out.println(minNumberOfJumps(arr));
	}

	public static int minNumberOfJumps(int[] array) {
		int[] distances = new int[array.length];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[0] = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j <= array[i]; j++) {
				if (i + j < array.length && distances[i] + 1 < distances[i + j])
					distances[i + j] = distances[i] + 1;
			}
		}
		
		return distances[array.length - 1];
	}

}
