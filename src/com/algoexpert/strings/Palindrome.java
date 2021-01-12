package com.algoexpert.strings;

public class Palindrome {
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("a"));
	}

	public static boolean isPalindrome(String str) {
		int i = 0, j = str.length() - 1;
		while (i < str.length() && j >= 0) {
			if (str.charAt(i++) != str.charAt(j--))
				return false;
		}
		return true;
	}

}
