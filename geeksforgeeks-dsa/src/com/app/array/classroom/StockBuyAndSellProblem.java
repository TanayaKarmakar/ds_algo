package com.app.array.classroom;

public class StockBuyAndSellProblem {
	private static int maxProfit(int[] arr) {
		int profit = 0;
		int minPrice = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < minPrice) {
				minPrice = arr[i];
			}
			if(arr[i] - minPrice > profit) {
				profit = arr[i] - minPrice;
			}
		}
		
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 200, 500, 1000, 700, 30, 400, 900, 400, 50 };

		System.out.println("max profit - " + maxProfit(arr));
	}

}
