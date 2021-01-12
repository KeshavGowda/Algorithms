package com.algoexpert.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RiverSizes {

	public static List<Integer> riverSizes(int[][] matrix) {
		List<Integer> sizes = new ArrayList<Integer>();
		Map<Integer, Set<Integer>> visited = new HashMap<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int size = getRiverSize(matrix, i, j, visited);
				if (size > 0)
					sizes.add(size);
			}
		}
		return sizes;
	}
	
	private static int getRiverSize(int[][] matrix, int i, int j, Map<Integer, Set<Integer>> visited) {
		int size = 0;
		if (matrix[i][j] == 1 && ! checkVisited(i, j, visited)) {
			addToVisited(i, j, visited);
			size++;
			if (i - 1 >= 0 && matrix[i - 1][j] == 1 && ! checkVisited(i - 1, j, visited)) {
				size += getRiverSize(matrix, i - 1, j, visited);
			}
			if (i + 1 < matrix.length && matrix[i + 1][j] == 1 && ! checkVisited(i + 1, j, visited)) {
				size += getRiverSize(matrix, i + 1, j, visited);
			}
			if (j - 1 >= 0 && matrix[i][j - 1] == 1 && ! checkVisited(i, j - 1, visited)) {
				size += getRiverSize(matrix, i, j - 1, visited);
			}
			if (j + 1 < matrix[0].length && matrix[i][j + 1] == 1 && ! checkVisited(i, j + 1, visited)) {
				size += getRiverSize(matrix, i, j + 1, visited);
			}
		}
		return size;
	}
	
	private static boolean checkVisited(int i, int j, Map<Integer, Set<Integer>> visited) {
		if (visited.containsKey(i)) {
			if (visited.get(i).contains(j))
				return true;
		}
		return false;
	}
	
	private static void addToVisited(int i, int j, Map<Integer, Set<Integer>> visited) {
		if (visited.containsKey(i)) {
			visited.get(i).add(j);
		} else {
			Set<Integer> set = new HashSet<>();
			set.add(j);
			visited.put(i, set);
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = new int[5][];
		arr[0] = new int[] {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		arr[1] = new int[] {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0};
		arr[2] = new int[] {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1};
		arr[3] = new int[] {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0};
		arr[4] = new int[] {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1};
		System.out.println(riverSizes(arr));
	}

}
