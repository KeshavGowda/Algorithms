package com.algoexpert.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3};
		Arrays.stream(quickSort(arr)).forEach(System.out::print);
	}

	public static int[] quickSort(int[] array) {
		int pivot  = 0;
		array = sort(array, pivot + 1, array.length - 1, pivot);
		return array;
	}
	
	private static int[] sort(int[] arr, int l, int r, int p) {
		int l1 = l, r1 = r;
		if (l > r) {
			return arr;
		}
		while (l < r) {
			if (arr[l] > arr[p] && arr[r] < arr[p]) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				l++;
				r--;
			} else if (arr[l] <= arr[p]) {
				l++;
			} else if (arr[r] >= arr[p]) {
				r--;
			}
		}
		int temp = arr[p];
		arr[p] = arr[r];
		arr[r] = temp;
		// TODO: call sort on smaller sub array first to save stack space on recursion
		arr = sort(arr, l1, r - 1, p);
		arr = sort(arr, r + 2, r1, r + 1);
		return arr;
	}

}
