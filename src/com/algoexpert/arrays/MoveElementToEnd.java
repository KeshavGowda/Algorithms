package com.algoexpert.arrays;

import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {
	
	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2);
		array = moveElementToEnd(array, 2);
		System.out.println(array);
	}
	
	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		int i = 0, j = array.size() - 1;
		while (i <= j) {
			if(array.get(i) == toMove) {
				while(array.get(j) == toMove && j - 1 >= i) {
					j--;
				}
				swap(array, i, j);
				i++;
				j--;
			} else {
				i++;
			}
		}
		return array;
	}

	private static void swap(List<Integer> array, int i, int j) {
		int temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
	}
	
}
