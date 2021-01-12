package com.algoexpert.sorting;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {8, 5, 2, 9, 5, 6, 3};
		Arrays.stream(bubbleSort(arr)).forEach(System.out::print);
	}

	public static int[] bubbleSort(int[] array) {
		boolean swap = false;
		do {
			swap = false;
			for (int i = 1; i < array.length; i++) {
				if (array[i] < array[i - 1]) {
					int temp = array[i];
					array[i] = array[i - 1];
					array[i - 1] = temp;
					swap = true;
				}
			}
		} while (swap);
		return array;
	}

}
