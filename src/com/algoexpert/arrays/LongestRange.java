package com.algoexpert.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestRange {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,11,3,0,15,5,2,4,10,7,12,6};
		int[] ans = largestRange(new int[] {1});
		Arrays.stream(ans).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] largestRange(int[] array) {
		int[] ans = new int[2];
		int maxLength = 0;
		if(array.length == 1)
			return new int[] {array[0], array[0]};
		Map<Integer, Boolean> map = new HashMap<>();
		for(int i = 0; i < array.length; i++) {
			map.put(array[i], false);
		}
		for(int i = 0; i < array.length; i++) {
			if(!map.get(array[i])) {
				map.put(array[i], true);
				int length = 0;
				int b = array[i] - 1, a = array[i] + 1;
				for(Integer entry : map.keySet()) {
					if(entry == a) {
						map.put(entry, true);
						length++;
						a++;
					} 
				}
				for(Integer entry : map.keySet()) {
					if(entry == b) {
						map.put(entry, true);
						length++;
						b--;
					} 
				} 
				if(length > maxLength) {
					ans[0] = ++b;
					ans[1] = --a;
					maxLength = length;
				}
			}
		}
		return ans;
  }

}
