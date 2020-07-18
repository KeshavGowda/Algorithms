package com.keshav.problems;

import java.util.Arrays;

public class InsertionSort {
	
	// Complete the insertionSort2 function below.
    static int insertionSort2(int n, int[] arr) {
    	int shifts = 0;
    	int i = 0, j, temp;
    	if(n == 1) {
    		System.out.println(Arrays.toString(arr).replaceAll(",|]|\\[", ""));
    		return shifts;
    	}
    	while(i+1 < arr.length) {
    		if(arr[i] > arr[i+1]) {
    			j = i;
    			temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				shifts++;
    			while(j>0) {
    				if(arr[j] < arr[j-1]) {
    					temp = arr[j];
    					arr[j] = arr[j-1];
    					arr[j-1] = temp;
    					shifts++;
    				} else {
    					break;
    				}
    				j--;
    			}
    		}
    		i++;
    		System.out.println(Arrays.toString(arr).replaceAll(",|]|\\[", ""));
    	}
    	return shifts;
    }
    
 // Complete the runningTime function below.
    static int runningTime(int[] arr) {
    	return insertionSort2(arr.length, arr);
    }
	
	public static void main(String[] args) {
		int[] arr = {5, 4, 3, 2, 1};
		//insertionSort2(arr.length, arr);
		System.out.println("Number of shifts:" + runningTime(arr));
	}

}
