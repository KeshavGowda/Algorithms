package com.algoexpert.arrays;

public class LongestPeak {
	
	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,3,4,0,10,6,5,-1,-3,2,3};
		int[] array2 = new int[] {1,3,2};
		int[] array3 = new int[] {1,2,3,4,5,1};
		int length = longestPeak(array3);
		System.out.println(length);
	}
	
	public static int longestPeak(int[] array) {
		int peak = 1;
		int maxLength = 0;
		while(peak < array.length - 1) {
			if(array[peak] > array[peak - 1] && array[peak] > array[peak + 1]) {
				int i = peak - 1, j = peak + 1;
				while(i - 1 >= 0 && array[i] > array[i - 1])
					i--;
				while(j + 1 < array.length && array[j] > array[j + 1])
					j++;
				int length = j - i + 1;
				if(length > maxLength)
					maxLength = length;
				peak = j + 1;
			} else {
				peak++;
			}
		}
		return maxLength;
	}

}
