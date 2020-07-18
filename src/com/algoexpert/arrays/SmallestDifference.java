package com.algoexpert.arrays;

import java.util.Arrays;

public class SmallestDifference {
	
	public static void main(String[] args) {
		int[] arr1 = new int[] {-1, 5, 10, 20, 28, 3};
		int[] arr2 = new int[] {26, 134, 135, 15, 17};
		int[] res = smallestDifference(arr1, arr2);
		System.out.println(res[0] + " " + res[1]);
	}
	
	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		int[] res = new int[2];
		int minDiff = Integer.MAX_VALUE;
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int i = 0, j = 0;
		while (i < arrayOne.length && j < arrayTwo.length) {
			int diff = Math.abs(arrayOne[i] - arrayTwo[j]);
			if (diff < minDiff) {
				minDiff = diff;
				res = new int[] {arrayOne[i], arrayTwo[j]};
			}
			if (arrayOne[i] < arrayTwo[j]) {
				i++;
			} else {
				j++;
			}
		}
		return res;
	}
}
