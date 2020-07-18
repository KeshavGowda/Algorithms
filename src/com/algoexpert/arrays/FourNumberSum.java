package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourNumberSum {

	public static void main(String[] args) {
		int[] array = new int[] { 7, 6, 4, -1, 1, 2 };
		for(Integer[] arr : fourNumberSum(array, 16)) {
			Arrays.stream(arr).forEach(System.out::print);
			System.out.println();
		}
	}

	public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
		List<Integer[]> soln = new ArrayList<>();
		Map<Integer, List<Integer[]>> sums = new HashMap<>();
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				int rem = targetSum - (array[i] + array[j]);
				if(sums.containsKey(rem)) {
					for(Integer[] pairs : sums.get(rem)) {
						Integer[] quads = new Integer[4];
						quads[0] = array[i];
						quads[1] = array[j];
						quads[2] = pairs[0];
						quads[3] = pairs[1];
						soln.add(quads);
					}
				}
			}
			if(i - 1 >= 0) {
				for(int k = i - 1; k >= 0; k--) {
					int sum = array[i] + array[k];
					List<Integer[]> pairsList = new ArrayList<>();
					if(sums.containsKey(sum)) {
						pairsList = sums.get(sum);
					}
					Integer[] pairs = new Integer[2];
					pairs[0] = array[k];
					pairs[1] = array[i];
					pairsList.add(pairs);
					sums.put(sum, pairsList);
				}
			}
		}
	    return soln;
	  }

}
