package com.jasper.array;

public class LC0122_BestTimetoBuyandSellStockII {

	public int maxProfit(int[] prices) {

		if (prices.length == 0) {
			return 0;
		}

		int profits = 0;
		int minBuy = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prices[i - 1]) {
				profits += prices[i - 1] - minBuy;
				minBuy = prices[i];
			} else {

			}
		}
		if (prices[prices.length - 1] > minBuy) {
			profits += prices[prices.length - 1] - minBuy;
		}
		return profits;
	}

}
