package com.algoexpert.dynprog;

public class MinCutsPalindrome {

	public static void main(String[] args) {
		System.out.println(palindromePartitioningMinCuts("noonabbad"));
	}

	public static int palindromePartitioningMinCuts(String str) {
		if (isPalindrome(str))
			return 0;
		boolean[][] palindrome = new boolean[str.length() + 1][str.length() + 1];
		int[] minCuts = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				 boolean val = isPalindrome(str.substring(i, j));
				 palindrome[i][j] = val;
			}
		}
		for (int i = 1; i <= str.length(); i++) {
			if (palindrome[0][i] == true) {
				minCuts[i - 1] = 0;
			} else {
				minCuts[i - 1] = minCuts[i - 2] + 1;
				for (int j = 1; j < i; j++) {
					if (palindrome[j][i] == true) {
						minCuts[i - 1] = minCuts[j - 1] + 1;
						break;
					}
				}
			}
		}
		return minCuts[str.length() - 1];
	}
	
	private static boolean isPalindrome(String string) {
		int i = 0, j = string.length() - 1;
		while (i < j) {
			if (string.charAt(i++) != string.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

}
