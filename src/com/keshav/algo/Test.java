package com.keshav.algo;

import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		Test t = new Test();
	}
	
	public static long getWays(int n, List<Long> c) {
        int[][] costMatrix = new int[c.size() + 1][n + 1];
        for (int d = 1; d <= n; d++) {
        	for (int i = 0; i < c.size(); i++) {
        		long coin = c.get(i);
            	if (d <= coin) {
            		costMatrix[i][d] = costMatrix[i][d - (int)coin] + 1;
            	} else {
            		costMatrix[i][d] = costMatrix[i - 1][d];
            	}
            }
        }    
        return costMatrix[c.size()][n];
    }
	
}
