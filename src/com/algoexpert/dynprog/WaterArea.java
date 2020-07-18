package com.algoexpert.dynprog;

public class WaterArea {

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3 };
		System.out.println(waterArea(arr));
	}

	public static int waterArea(int[] heights) {
		int area = 0;
		int[] right = new int[heights.length];
		int[] left = new int[heights.length];
		for (int i = 0; i < heights.length; i++) {
			for (int j = i; j - 1 >= 0; j--) {
				if (heights[j - 1] >= left[i]) {
					left[i] = heights[j - 1];
				}
			}
			for (int j = i; j + 1 < heights.length; j++) {
				if (heights[j + 1] >= right[i]) {
					right[i] = heights[j + 1];
				}
			}
			
		}
		for (int i = 0; i < heights.length; i++) {
			if (right[i] > heights[i] && left[i] > heights[i]) {
				int pillarHeight = Math.min(right[i], left[i]);
				area += pillarHeight - heights[i];
			}
		}
		
		return area;
	}

}
