package com.keshav.problems;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
	
	// Complete the quickSort function below.
    static List<Integer> quickSort(List<Integer> arr) {
    	List<Integer> left = new ArrayList<>();
    	List<Integer> right = new ArrayList<>();
    	List<Integer> equal = new ArrayList<>();
    	if(arr.isEmpty() || arr.size() ==1 ) {
    		return arr;
    	} else {
    		int pivot = arr.get(0);
        	for(int i=0; i<arr.size(); i++) {
        		if(arr.get(i) < pivot) left.add(arr.get(i));
        		if(arr.get(i) > pivot) right.add(arr.get(i));
        		if(arr.get(i) == pivot) equal.add(arr.get(i));
        	}
    	}
    	left = quickSort(left);
    	right = quickSort(right);
    	left.addAll(equal);
    	left.addAll(right);
    	return left;
    }

	public static void main(String[] args) {
		List<Integer> unsorted = new ArrayList<>();
		unsorted.add(4);unsorted.add(5);unsorted.add(3);unsorted.add(7);unsorted.add(2);
		System.out.println(quickSort(unsorted));
	}
	
}
