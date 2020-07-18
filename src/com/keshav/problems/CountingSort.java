package com.keshav.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CountingSort {
	
	// Complete the countingSort function below.
    static int[] countingSort(int[] arr) {
    	int[] occurs = new int[100];
    	int temp;
    	for(int i=0; i<arr.length; i++) {
    		temp = occurs[arr[i]] + 1;
    		occurs[arr[i]] = temp;
    	}
    	int index = 0;
    	int[] sorted = new int[arr.length];
    	for(int i=0; i<occurs.length; i++) {
    		int occurrences = occurs[i];
    		for(int j=0; j<occurrences; j++) {
    			sorted[index++] = i;
    		}
    	}
    	return sorted;
    }
    
 // Complete the closestNumbers function below.
    static void closestNumbers(int[] arr) {
    	LinkedList<Integer> closest = new LinkedList<>();
    	Arrays.sort(arr);
    	int absd = arr[1] - arr[0];
    	closest.add(arr[0]);
    	closest.add(arr[1]);
    	int i = 1;
    	while(i+1 < arr.length) {
    		if(arr[i+1] - arr[i] == absd) {
    			closest.add(arr[i]);
    			closest.add(arr[i+1]);
    		}
    		else if(arr[i+1] - arr[i] < absd) {
    			absd = arr[i+1] - arr[i];
    			closest.clear();
    			closest.add(arr[i]);
    			closest.add(arr[i+1]);
    		}
    		i++;
    	}
    	System.out.println(closest.toString().replaceAll(",|]|\\[", ""));
    }

    
    public static void main(String[] args) {
    	//int[] arr = {63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70, 33};
    	//System.out.println(Arrays.toString(countingSort(arr)).replaceAll(",|]|\\[", ""));
    	int[] arr = {-5, 15, 25, 71, 63};
    	closestNumbers(arr);
    }
    
}
