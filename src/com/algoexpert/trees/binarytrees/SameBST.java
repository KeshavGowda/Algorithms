package com.algoexpert.trees.binarytrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBST {

	public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
		if (arrayOne.size() != arrayTwo.size())
			return false;
		if (arrayOne.size() == 0 && arrayTwo.size() == 0)
			return true;
		if (arrayOne.get(0) != arrayTwo.get(0))
			return false;
			
		List<Integer> left1 = new ArrayList<>();
		List<Integer> right1 = new ArrayList<>();
		divideArray(arrayOne, left1, right1);
		
		List<Integer> left2 = new ArrayList<>();
		List<Integer> right2 = new ArrayList<>();
		divideArray(arrayTwo, left2, right2);
		
		return sameBsts(left1, left2) && sameBsts(right1, right2);
		
	}
	
	private static void divideArray(List<Integer> array, List<Integer> left, List<Integer> right) {
		int root = array.get(0);
		for (int i = 1; i < array.size(); i++) {
			if (array.get(i) < root)
				left.add(array.get(i));
			else
				right.add(array.get(i));
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11);
		List<Integer> list2 = Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81);
		System.out.println(sameBsts(list1, list2));
	}

}
