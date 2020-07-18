package com.keshav.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class gs_q1 {
	
	private static List<Integer> getArrayResult(List<Integer> inputArray) {
		List<Integer> result = new LinkedList<>();
		for(int i = 0; i < inputArray.size(); i++) {
			int res = 0;
			boolean isFirst = true;
			for(int j = 0; j < inputArray.size(); j++) {
				if(j == i)
					continue;
				else {
					if(isFirst) {
						res = inputArray.get(j);
						isFirst = false;
					}
					else
						res *= inputArray.get(j);
				}	
			}
			result.add(res);
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> inputArray = new ArrayList<>();
		inputArray.add(1);
		inputArray.add(2);
		inputArray.add(3);
		inputArray.add(4);
		inputArray.add(5);
		List<Integer> result = getArrayResult(inputArray);
		for(Integer i : result)
			System.out.println(i);
	}

}
