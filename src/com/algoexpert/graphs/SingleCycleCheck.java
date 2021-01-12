package com.algoexpert.graphs;

import java.util.HashSet;
import java.util.Set;

public class SingleCycleCheck {

	public static boolean hasSingleCycle(int[] array) {
		Set<Integer> visited = new HashSet<>();
		int index = 0;
		while (visited.size() <= array.length) {
			if (visited.add(index)) {
				int move = array[index] % array.length;
				index += move;
				if (index >= array.length)
					index -= array.length;
				if (index < 0)
					index += array.length;
			} else {
				break;
			}
		}
		return (index == 0 && visited.size() == array.length) ? true : false;
	}

	public static boolean hasSingleCycle2(int[] array) {
		int visited = 0;
		int index = 0;
		while (visited < array.length) {
			visited++;
			int move = array[index] % array.length;
			index += move;
			if (index >= array.length)
				index -= array.length;
			if (index < 0)
				index += array.length;
			if (index == 0 && visited != array.length)
				return false;
		}
		return index == 0;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 1, -4, -4, 2 };
		// int[] arr = new int[] {2, 2};
		// int[] arr = new int[] {1, 1, 1, 1, 2};
		//int[] arr = new int[] {1, -1, 1, -1};
		System.out.println(hasSingleCycle2(arr));
	}

}
