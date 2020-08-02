package com.algoexpert.dynprog;

public class MaxProfitWithKtransactions {
	
	public static void main(String[] args) {
		int[] prices = new int[] {5, 11, 3, 50, 60, 90};
		System.out.println(maxProfitWithKTransactions(prices, 2));
	}

	public static int maxProfitWithKTransactions(int[] prices, int k) {
		if (prices.length == 0)
			return 0;
		int[][] profit = new int[prices.length][k + 1];
		for (int t = 1; t < profit[0].length; t++) {
			for (int d = 1; d < profit.length; d++) {
				int withoutSelling = profit[d - 1][t];
				int maxProfitWhenSold = Integer.MIN_VALUE;
				for (int x = 0; x < d; x++) {
					if (t > 0) {
						int maxProfitforX = -prices[x] + profit[x][t - 1];
						if (maxProfitforX > maxProfitWhenSold)
							maxProfitWhenSold = maxProfitforX;
					}
				}
				int whenSold = prices[d] + maxProfitWhenSold;
				profit[d][t] = Math.max(withoutSelling, whenSold);
			}
		}
		return profit[prices.length - 1][k];
	}

}
