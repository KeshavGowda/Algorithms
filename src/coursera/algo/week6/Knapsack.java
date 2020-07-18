package coursera.algo.week6;

import java.util.*;

public class Knapsack {
	static int optimalWeight(int W, int[] w) {
		int[][] value = new int[W + 1][w.length + 1];
		for(int j = 1; j < w.length + 1; j++) {
			for(int i = 1; i < W + 1; i++) {
				int prev = value[i][j - 1];
				int curr = w[j-1] + value[W - w[j-1]][j - 1];
				if(curr > i) 
					value[i][j] = prev;
				else 
					value[i][j] = Math.max(prev, curr);	
			}
		}
		
		return value[W][w.length];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int W, n;
		W = scanner.nextInt();
		n = scanner.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = scanner.nextInt();
		}
		System.out.println(optimalWeight(W, w));
	}
}

