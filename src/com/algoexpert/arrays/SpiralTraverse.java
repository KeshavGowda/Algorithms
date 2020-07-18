package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraverse {
	
	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		arr[0][0] = 1; arr[0][1] = 2; arr[0][2] = 3; arr[0][3] = 4;
		arr[1][0] = 12; arr[1][1] = 13; arr[1][2] = 14; arr[1][3] = 5;
		arr[2][0] = 11; arr[2][1] = 16; arr[2][2] = 15; arr[2][3] = 6;
		arr[3][0] = 10; arr[3][1] = 9; arr[3][2] = 8; arr[3][3] = 7;
		int[][] arr2 = new int[][] {{1}};
		int[][] arr3 = new int[][] {{1,2}, {4,3}};
		int[][] arr4 = new int[][] {{1, 2, 3, 4, 5, 6, 7, 8, 9},
			    {22, 23, 24, 25, 26, 27, 28, 29, 10},
			    {21, 36, 35, 34, 33, 32, 31, 30, 11},
			    {20, 19, 18, 17, 16, 15, 14, 13, 12}};
	    int[][] arr5 = new int[][] {{1, 2, 3, 4},
	        {22, 23, 24, 5},
	        {21, 36, 25, 6},
	        {20, 35, 26, 7},
	        {19, 34, 27, 8},
	        {18, 33, 28, 9},
	        {17, 32, 29, 10},
	        {16, 31, 30, 11},
	        {15, 14, 13, 12}};
	    int[][] arr6 = new int[][] {{1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}};
		List<Integer> list = spiralTraverse(arr6);
		System.out.println(list);
	}
	
	public static List<Integer> spiralTraverse(int[][] array) {
		List<Integer> res = new ArrayList<>();
		/* square boundaries */
		int i = array[0].length - 1, j = 0, k = array[0].length - 1, l = array.length - 1;
		while(j <= i && j <= l) {
			for(int z = j; z <= i; z++) {
				res.add(array[j][z]);
			}
			for(int z = j + 1; z < l; z++) {
				res.add(array[z][k]);
			}
			for(int z = k; z > j; z--) {
				res.add(array[l][z]);
			}
			for(int z = l; z > j; z--) {
				res.add(array[z][j]);
			}
			j++; i--;
			l--; k--;
		}
		return res;
	}

	public static List<Integer> spiralTraverse2(int[][] array) {
		List<Integer> res = new ArrayList<>();
		/* square boundaries */
		int i = array[0].length - 1, j = 0, k = array[0].length - 1, l = array.length - 1;
		while(j <= l) {
			for(int z = j; z < i; z++) {
				res.add(array[j][z]);
			}
			for(int z = j; z < k; z++) {
				res.add(array[z][k]);
			}
			for(int z = k; z > j; z--) {
				res.add(array[l][z]);
			}
			for(int z = l; z > j; z--) {
				res.add(array[z][j]);
			}
			j++; i--;
			l--; k--;
		}
		return res;
	}

}
