package com.algoexpert.dynprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack {
	
	public static void main(String[] args) {
		int[][] items = new int[][] {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
		int[][] items2 = new int[][] {{2, 1}, {70, 70}, {30, 30}, {69, 69}, {100, 100}};
		System.out.println(knapsackProblem(items2, 100));
	}
	
	public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
	    int[][] value = new int[capacity + 1][items.length + 1];
	    
	    for (int i = 1; i <= capacity; i++) {
	    	for (int j = 1; j <= items.length; j++) {
	    		if (items[j - 1][1] <= i) {
	    			int woItem = value[i][j - 1];
	    			int withItem = items[j - 1][0] + value[i - items[j - 1][1]][j - 1];
	    			value[i][j] = Math.max(woItem, withItem);
	    		} else {
	    			value[i][j] = value[i][j - 1];
	    		}
	    	}
	    }
	    // Backtrack to find items included
	    List<Integer> included = new ArrayList<>();
	    int i = capacity;
	    int j = items.length;
	    while (i >= 1 && j >= 1) {
	    	if (value[i][j] == value[i][j - 1]) {
	    		j--;
	    	} else {
	    		included.add(0, j - 1);
	    		i -= items[j - 1][1];
	    		j--;
	    	}
	    }
	    
	    List<List<Integer>> sol = new ArrayList<>();
		List<Integer> maxVal = new ArrayList<>();
	    int max = value[capacity][items.length];
	    maxVal.add(max);
	    sol.add(maxVal);
	    sol.add(included);
	    return sol;
	  }

}
