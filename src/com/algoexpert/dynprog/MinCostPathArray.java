package com.algoexpert.dynprog;

import java.util.HashMap;
import java.util.Map;

public class MinCostPathArray {
	
	public static void main(String[] args) {
		int[][] array = new int[4][];
		int[] a1 = new int[] {1, 4, 4};
		int[] a2 = new int[] {3, 2, 3};
		int[] a3 = new int[] {5, 1, 2};
		int[] a4 = new int[] {8, 7, 3};
		array[0] = a1;
		array[1] = a2;
		array[2] = a3;
		array[3] = a4;
		System.out.println(minCost(array, array.length - 1, array[0].length - 1));
	}
	
	private static Map<String, Integer> cache = new HashMap<>();
	
	public static int minCost(int[][] array, int i, int j) {
		System.out.println(i + " " + j);
		
		if (cache.containsKey(i + "" + j))
			return cache.get(i + "" + j);
		
		int cost = array[i][j];
		
		if (i == 0 && j == 0) {
			return cost;
		} else if (i == 0 && j > 0) {
			cost += minCost(array, i, --j);
		} else if (i > 0 && j == 0) {
			cost += minCost(array, --i, j);
		} else {
			cost += Math.min(minCost(array, --i, j), minCost(array, i, --j));
		}
		
		cache.put(i + "" + j, cost);
		return cost;
	}

}
