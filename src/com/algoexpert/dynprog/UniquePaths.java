package com.algoexpert.dynprog;

public class UniquePaths {
	
	public static void main(String[] args) {
		System.out.println(totalPaths(4, 3));
	}
	
	private static int totalPaths(int m, int n) {
		int[][] pathMatrix = new int[m][n];
		int i = 1; 
		int j = 1;
		for (int a = 0; a < m; a++) {
			pathMatrix[a][0] = 1;
		}
		for (int b = 0; b < n; b++) {
			pathMatrix[0][b] = 1;
		}
		while(i < m && j < n) {
			pathMatrix[i][j] = pathMatrix[i - 1][j] + pathMatrix[i][j - 1];
			i++;
			if(i == m) {
				i = 1;
				j++;
			}
		}
		return pathMatrix[m - 1][n - 1];
	}

}
