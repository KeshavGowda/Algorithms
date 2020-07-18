package com.keshav.problems;

import java.util.Arrays;
import java.util.Comparator;

public class BigSorting {

	public static void bigSort() {
		String[] unsorted = {"31415926535897932384626433832795", "1", "3", "10", "3", "5"};
		String[] unsorted2 = {"613", "612", "500", "6593893", "284575", "78423139", "548203", "46520", "76589475", "9376363"};
		String[] unsorted3 = {"abe", "abc"};
		Arrays.sort(unsorted2, new NumericStringCompare());
		System.out.println(Arrays.toString(unsorted2));
	}

	private static class NumericStringCompare implements Comparator<String> {

		@Override
		public int compare(String a, String b) {
			if(a.length() == 1 && b.length() == 1) {
				return a.compareTo(b);
			}
			else if(a.length() == b.length()) {
				int val = 0;
				if(a.charAt(0) > b.charAt(0)) { return 1; } 
				else if(a.charAt(0) < b.charAt(0)) { return -1; }
				else {
					for(int i=1; i<a.length(); i++) {
						val = compare(a.substring(i), b.substring(i));
						if(val != 0) break;
					}
				}
				return val;
			} else {
				return a.length() > b.length() ? 1 : -1;
			}
		}	

	}

	public static void main(String[] args) {
		bigSort();
	}

}
