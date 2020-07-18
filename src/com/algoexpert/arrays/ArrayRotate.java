package com.algoexpert.arrays;

import java.util.Arrays;

public class ArrayRotate {
	
	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4,5,6,7};
		int[] array2 = new int[] {1,2,3,4,5,6,7};
		rotate(array, 3);
		rotate2(array2, 3);
	}

	public static void rotate(int[] nums, int k) {
        for(int i=0; i<k; i++) {
            int temp = nums[nums.length - 1];
            for(int j=nums.length - 1; j >=0; j--) {
                if(j==0) {
                    nums[j] = temp;
                } else {
                    nums[j] = nums[j-1];   
                }
            }
        }
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
    }
	
	public static void rotate2(int[] nums, int k) {
		int[] arr = new int[nums.length];
		int index = k % nums.length;
		for(int i = index, j = 0; i < nums.length && j < nums.length; i++, j++) {
			arr[i] = nums[j];
			if(i + 1 == nums.length)
				i = -1;
		}
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
	}
}
