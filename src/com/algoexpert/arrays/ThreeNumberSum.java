package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
	
	public static void main(String[] args) {
		int[] arr = new int[] {12, 3, 1, 2, -6, 5, -8, 6};
		List<Integer[]> results = threeNumberSum(arr, 0);
		for(Integer[] val : results) {
			System.out.println(val[0] + "," + val[1] + "," + val[2]);
		}
	}
	
	// O(n^2) time | O(n) space
	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		List<Integer[]> results = new ArrayList<>();
		Arrays.sort(array);
		for(int cur = 0; cur < array.length - 2; cur++) {
			int left = cur + 1;
			int right = array.length - 1;
			while (left < right) {
				int cursum = array[cur] + array[left] + array[right];
				if (cursum == targetSum) {
					results.add(new Integer[] {array[cur], array[left], array[right]});
					left++;
					right--;
				} else if (cursum < targetSum) {
					left++;
				} else {
					right--;
				}
			}
		}
		return results;
	}

}
