package com.algoexpert.dynprog;

public class MinCoinChange {
	
	public static void main(String[] args) {
		int[] denoms = new int[] {3, 5};
		int amount = 9;
		System.out.println(minNumberOfCoinsForChange(amount, denoms));
	}

	public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		int[] minCoins = new int[n + 1];
		if (n == 0)
			return 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < denoms.length; j++) {
				if (denoms[j] == i) {
					minCoins[i] = 1;
					break;
				} else if (denoms[j] < i) {
					int rem = i - denoms[j];
					if (minCoins[rem] != 0) {
						int coins = 1 + minCoins[rem];
						if (minCoins[i] == 0 || coins < minCoins[i])
							minCoins[i] = coins;
					}
				}
			}
		}
		return minCoins[n] == 0 ? -1 : minCoins[n];
	}

}
