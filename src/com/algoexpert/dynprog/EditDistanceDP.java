package com.algoexpert.dynprog;

public class EditDistanceDP {
	
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "";
		System.out.println(levenshteinDistance(s1, s2));
	}
	
	public static int levenshteinDistance(String str1, String str2) {
	    int[][] editD = new int[str2.length() + 1][str1.length() + 1];
	    
	    for (int i = 0; i <= str2.length(); i++) {
	    	editD[i][0] = i;
	    }
	    for (int i = 0; i <= str1.length(); i++) {
	    	editD[0][i] = i;
	    }
	    
	    for (int i = 1; i <= str2.length(); i++) {
	    	for (int j = 1; j <= str1.length(); j++) {
	    		if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
	    			editD[i][j] = editD[i - 1][j - 1];
	    		} else {
	    			editD[i][j] = minimum(editD[i - 1][j - 1], editD[i - 1][j], editD[i][j - 1]) + 1;
	    		}
	    	}
	    }
	    
	    return editD[str2.length()][str1.length()];
	  }
	
	private static int minimum(int a, int b, int c) {
		int min = a > b ? b : a;
		return c > min ? min : c;
	}

}
