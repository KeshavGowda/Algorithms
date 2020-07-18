package com.algoexpert.arrays;

import java.util.Arrays;

public class SubarraySort {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
		int[] array2 = new int[] { 1, 2, 8, 4, 5};
		int[] array3 = new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19 };
		int[] arr = subarraySort(array2);
		System.out.println(arr[0] + " " + arr[1]);
	}

	public static int[] subarraySort(int[] array) {
		int[] ans = new int[] { -1, -1 };
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		if (array.length <= 2) {
			if (array[0] <= array[1]) {
				return ans;
			} else {
				return new int[] { 0, 1 };
			}
		}
		for (int i = 0; i + 1 < array.length; i++) {
			if (array[i] > array[i + 1]) {
				if (array[i + 1] < min)
					min = array[i + 1];
				if (array[i] > max)
					max = array[i];
			}
		}
		for(int i = 0; i + 1 < array.length; i++) {
			if(i == 0 && min < array[i]) {
				ans[0] = i;
				break;
			} else if(min >= array[i] && min < array[i + 1]) {
				ans[0] = i + 1;
				break;
			}
		}
		for(int i = array.length - 1; i - 1 >= 0; i--) {
			if(i == array.length - 1 && max > array[i]) {
				ans[1] = i;
				break;
			} else if(max <= array[i] && max > array[i - 1]) {
				ans[1] = i - 1;
				break;
			}
		}
		return ans;
	}

}
