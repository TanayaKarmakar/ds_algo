package com.app.array.classroom;

//Given an array of stock prices, find the maximum
//profit that can be earned by performing multiple non 
//overlapping transactions
public class StockBuyAndSellProblemType2 {
	private static int maxProfit(int[] arr) {
		int profit = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] > 0) {
				profit += arr[i] - arr[i - 1];
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		int[] arr = { 100, 80, 120, 130, 70, 60, 100, 125 };
		System.out.println("Maximum profit - " + maxProfit(arr));

	}

}
