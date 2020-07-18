package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTraverse {
	
	public static void main(String[] args) {
		System.out.println(zigzagTraverse(getArray1()));
		System.out.println(zigzagTraverse(getArray2()));
		System.out.println(zigzagTraverse(getArray3()));
		System.out.println(zigzagTraverse(getArray4()));
	}

	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
		List<Integer> res = new ArrayList<>();
		int i = 0, k = 0, j = 0, l = 0;
		boolean down = false;
		while(i < array.get(0).size() && j < array.size()) {       
			if(i == 0 && l == 0) {
				res.add(array.get(j).get(i));
			} else if(l == array.get(0).size() - 1 && k == array.size() - 1) {
				res.add(array.get(j).get(i));
				break;
			} else {
				if(l >= array.get(0).size() || k >= array.size()) 
					break;
				else if(down == true) 
					down = upwardRight(i, k, j, l, array, res);
				else
					down = downwardLeft(i, k, j, l, array, res);
			}
			if(i == array.get(0).size() - 1)
				k++;
			else 
				i++;
			if(j == array.size() - 1)
				l++;
			else 
				j++;
		}
		return res;
	}
	
	private static boolean upwardRight(int i, int k, int j, int l, List<List<Integer>> array, List<Integer> res) {
		int a = k, b = i;
		do {
			res.add(array.get(a).get(b));
			a++;
			b--;
		} while (a <= j);
		return false;
	}
	
	private static boolean downwardLeft(int i, int k, int j, int l, List<List<Integer>> array, List<Integer> res) {
		int a = l, b = j;
		do {
			res.add(array.get(b).get(a));
			a++;
			b--;
		} while (b >= k);
		return true;
	}
	
	private static List<List<Integer>> getArray1() {
		List<List<Integer>> array = new ArrayList<>();
		List<Integer> arr1 = new ArrayList<>();
		arr1.add(1);arr1.add(2);arr1.add(6);arr1.add(7);
		array.add(arr1);
		List<Integer> arr2 = new ArrayList<>();
		arr2.add(3);arr2.add(5);arr2.add(8);arr2.add(13);
		array.add(arr2);
		List<Integer> arr3 = new ArrayList<>();
		arr3.add(4);arr3.add(9);arr3.add(12);arr3.add(14);
		array.add(arr3);
		List<Integer> arr4 = new ArrayList<>();
		arr4.add(10);arr4.add(11);arr4.add(15);arr4.add(16);
		array.add(arr4);
		return array;
	}
	
	private static List<List<Integer>> getArray2() {
		List<List<Integer>> array = new ArrayList<>();
		List<Integer> arr1 = new ArrayList<>();
		arr1.add(1);arr1.add(2);
		array.add(arr1);
		List<Integer> arr2 = new ArrayList<>();
		arr2.add(3);arr2.add(5);
		array.add(arr2);
		List<Integer> arr3 = new ArrayList<>();
		arr3.add(4);arr3.add(9);
		array.add(arr3);
		List<Integer> arr4 = new ArrayList<>();
		arr4.add(10);arr4.add(11);
		array.add(arr4);
		return array;
	}
	
	private static List<List<Integer>> getArray3() {
		List<List<Integer>> array = new ArrayList<>();
		List<Integer> arr1 = new ArrayList<>();
		arr1.add(1);arr1.add(2);arr1.add(5);arr1.add(6);
		array.add(arr1);
		List<Integer> arr2 = new ArrayList<>();
		arr2.add(3);arr2.add(4);arr2.add(7);arr2.add(8);
		array.add(arr2);
		return array;
	}
	
	private static List<List<Integer>> getArray4() {
		List<List<Integer>> array = new ArrayList<>();
		List<Integer> arr1 = new ArrayList<>();
		arr1.add(1);
		array.add(arr1);
		return array;
	}
}
