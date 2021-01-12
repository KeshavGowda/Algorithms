package com.algoexpert.sorting;

import java.util.Arrays;

public class InsertionSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {8, 5, 2, 9, 5, 6, 3};
		Arrays.stream(insertionSort(arr)).forEach(System.out::print);
	}

	public static int[] insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				array = insertionSort(array, i);
			}
		}
		return array;
	}
	
	private static int[] insertionSort(int[] arr, int index) {
		for (int i = 0; i < index; i++) {
			if (arr[index] <= arr[i]) {
				int temp = arr[index];
				for (int j = index; j > i; j--) {
					arr[j] = arr[j - 1];
				}
				arr[i] = temp;
				break;
			}
		}
		return arr;
	}

}
