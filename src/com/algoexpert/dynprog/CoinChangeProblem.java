package com.algoexpert.dynprog;

public class CoinChangeProblem {

	public static void main(String[] args) {
		int[] denoms = new int[] { 1, 5 };
		int amount = 6;
		System.out.println(numberOfWaysToMakeChange(amount, denoms));
	}

	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		int[] ways = new int[n + 1];
		ways[0] = 1;
		for (int j = 0; j < denoms.length; j++) {
			for (int i = 0; i < ways.length; i++) {
				if (denoms[j] <= i) {
					ways[i] += ways[i - denoms[j]];
				}
			}
		}
		return ways[n];
	}
}
