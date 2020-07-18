package com.algoexpert.dynprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonSubsequence {
	
	public static void main(String[] args) {
		String s1 = "clement";
		String s2 = "antoine";
		System.out.println(longestCommonSubsequence(s1, s2));
	}

	public static List<Character> longestCommonSubsequence(String str1, String str2) {
		List<Character> seq = new ArrayList<>();
		String[][] matrix = new String[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str2.length(); i++)
			for (int j = 0; j <= str1.length(); j++)
				matrix[j][i] = "";
		for (int i = 1; i <= str2.length(); i++) {
			for (int j = 1; j <= str1.length(); j++) {
				if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
					matrix[j][i] = matrix[j - 1][i - 1] + str2.charAt(i - 1);
				} else {
					if (matrix[j - 1][i].length() > matrix[j][i - 1].length())
						matrix[j][i] = matrix[j - 1][i] ;
					else
						matrix[j][i] = matrix[j][i - 1];
				}
			}
		}
		for (char c : matrix[str1.length()][str2.length()].toCharArray()) 
			seq.add(c);
		return seq;
	}

}
