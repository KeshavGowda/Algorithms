package com.algoexpert.sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {8, 5, 2, 9, 5, 6, 3};
		Arrays.stream(selectionSort(arr)).forEach(System.out::print);
	}

	public static int[] selectionSort(int[] array) {
		int sortIndex = 0;
		while (sortIndex < array.length) {
			int minIndex = sortIndex;
			for (int i = sortIndex + 1; i < array.length; i++) {
				if (array[i] < array[minIndex])
					minIndex = i;
			}
			int temp = array[sortIndex];
			array[sortIndex] = array[minIndex];
			array[minIndex] = temp;
			sortIndex++;
		}
		return array;
	}

}
