package com.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MinScore {
	
	public static void main(String[] args) {
		int[] arr = new int[] {8,4,2,1,3,6,7,9,5};
		System.out.println(minreward(arr));
	}
	
	public static int minreward(int[] scores) {
	    int[] reward = new int[scores.length];
	    for(int i = 0; i < reward.length; i++) {
	    	reward[i] = reward[i] + 1;
	    }
	    Map<Integer, List<Integer>> elem = new HashMap<>();
	    for(int i = 0; i < scores.length; i++) {
	    	List<Integer> adj = new ArrayList<>();
	    	if(i - 1 >= 0 && scores[i - 1] > scores[i]) {
	    		adj.add(i - 1);
	    	}
	    	if(i + 1 < scores.length && scores[i + 1] > scores[i]) {
	    		adj.add(i + 1);
	    	}
	    	elem.put(i, adj);
	    }
	    for(Entry<Integer, List<Integer>> entry : elem.entrySet()) {
	    	setRewards(elem, entry.getKey(), entry.getValue(), reward);
	    }
	    return Arrays.stream(reward).sum();
	}
	
	private static void setRewards(Map<Integer, List<Integer>> elem, int key, List<Integer> list, int[] reward) {
		for(Integer i : list) {
			if(reward[i] <= reward[key])
				reward[i] = reward[i] + 1;
    		setRewards(elem, i, elem.get(i), reward);
    	}
	}
	
}
