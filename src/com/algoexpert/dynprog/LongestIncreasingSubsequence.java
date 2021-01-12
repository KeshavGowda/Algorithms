package com.algoexpert.dynprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		int[] arr = new int[] {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};
		System.out.println(longestIncreasingSubsequence(arr));
	}

	public static List<Integer> longestIncreasingSubsequence(int[] array) {
		int[] lengths = new int[array.length];
		int[] sequences = new int[array.length];
		Arrays.fill(lengths, 1);
		Arrays.fill(sequences, -1);
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i] && lengths[j] + 1 >= lengths[i]) {
					lengths[i] = lengths[j] + 1;
					sequences[i] = j;
				}
			}
		}
		
		int maxIndex = 0;
		int maxVal = lengths[0];
		for (int i = 1; i < lengths.length; i++) {
			if (lengths[i] > maxVal) {
				maxVal = lengths[i];
				maxIndex = i;
			}
		}
		List<Integer> vals = new ArrayList<Integer>();
		while (maxIndex >= 0) {
			vals.add(0, array[maxIndex]);
			maxIndex = sequences[maxIndex];
		}
		
		return vals;
	}

}
