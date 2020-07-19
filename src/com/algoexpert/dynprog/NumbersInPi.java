package com.algoexpert.dynprog;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumbersInPi {

	public static void main(String[] args) {
		String pi = "3141592653589793238462643383279";
		String[] numbers = { "314159265358979323846", "26433", "8", "3279", "314159265", "35897932384626433832", "79" };
		String pi2 = "3141592";
		String[] numbers2 = { "3141", "5", "31", "2", "4159", "42" };
		String pi3 = "3141592";
		String[] numbers3 = { "3141592", "3141", "5", "31", "2", "4159", "42" };
		String[] numbers4 = { "3", "314", "49", "9001", "15926535897", "14", "9323", "8462643383279", "4", "793" };
		String pi4 = "3141592653589793238462643383279";
		System.out.println(numbersInPi(pi4, numbers4));
	}

	public static int numbersInPi(String pi, String[] numbers) {
		Set<String> nums = new HashSet<>();
		Map<String, Integer> numSpaces = new HashMap<>();
		addToSet(nums, numbers);
		findSpaces(nums, numSpaces, pi);
		return numSpaces.get(pi) == null ? -1 : numSpaces.get(pi);
	}

	private static void addToSet(Set<String> nums, String[] numbers) {
		for (String s : numbers) {
			nums.add(s);
		}
	}

	private static int findSpaces(Set<String> nums, Map<String, Integer> numSpaces, String pi) {
		if (numSpaces.containsKey(pi))
			return numSpaces.get(pi);
		if (nums.contains(pi) || pi.length() == 1) {
			numSpaces.put(pi, 0);
			return 0;
		}
		for (int i = 1; i < pi.length(); i++) {
			String prefix = pi.substring(0, i);
			if (nums.contains(prefix)) {
				String suffix = pi.substring(i);
				if (numSpaces.containsKey(suffix)) {
					return numSpaces.get(suffix);
				} else {
					int spaces = findSpaces(nums, numSpaces, suffix);
					if (spaces == -1)
						continue;
					if (!numSpaces.containsKey(prefix + suffix) || spaces < numSpaces.get(prefix + suffix))
						numSpaces.put(prefix + suffix, spaces + 1);
				}
			}
		}
		return numSpaces.get(pi) == null ? -1 : numSpaces.get(pi);
	}

}
