package com.algoexpert.dynprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumIncreasingSubsequence {
	
	public static void main(String[] args) {
		int[] arr = new int[] {10, 70, 20, 30, 50, 11, 30};
		System.out.println(maxSumIncreasingSubsequence(arr));
	}
	
	public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
		int[] sum = new int[array.length];
		List<List<Integer>> subSeq = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			int tempSum = array[i];
			List<Integer> seq = new ArrayList<>();
			int prevElem = i;
			for (int j = i - 1; j >= 0; j--) {
				if (array[i] > array[j] && sum[j] + array[i] > tempSum) {
					tempSum = sum[j] + array[i];
					prevElem = j;
				}
			}
			sum[i] = tempSum;
			if (prevElem != i) {
				seq.addAll(subSeq.get(prevElem));
				seq.add(array[i]);
			} else {
				seq.add(array[i]);
			}
			subSeq.add(seq);
		}
		int maxIndex = 0;
		int maxVal = sum[0];
		for (int i = 1; i < sum.length; i++) {
			if (sum[i] > maxVal) {
				maxVal = sum[i];
				maxIndex = i;
			}
		}
		List<List<Integer>> solution = new ArrayList<>();
		List<Integer> max = new ArrayList<>();
		max.add(sum[maxIndex]);
		solution.add(max);
		solution.add(subSeq.get(maxIndex));
		return solution;
	}

}
