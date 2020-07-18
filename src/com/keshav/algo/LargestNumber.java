package com.keshav.algo;

import java.util.*;

public class LargestNumber {
	private static String largestNumber(List<String> a) {
		String result = "";
		while(!a.isEmpty()) {
			String max = a.get(0);
			for(String d : a) {
				if(isGreaterOrEqual(d, max)) {
					max = d;
				}
			}
			result = result.concat(max);
			a.remove(max);
		}
		return result;
	}
	
	private static boolean isGreaterOrEqual(String a, String b) {
		String i = a + b;
		String j = b + a;
		if(Integer.valueOf(i) > Integer.valueOf(j))
			return true;
		else 
			return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		//String[] a = new String[n];
		List<String> a = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			a.add(scanner.next());
		}
		scanner.close();
		System.out.println(largestNumber(a));
	}
}


