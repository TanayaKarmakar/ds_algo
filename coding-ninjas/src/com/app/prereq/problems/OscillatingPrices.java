package com.app.prereq.problems;

import java.util.Scanner;

public class OscillatingPrices {
	private static int findMaxProfit(int[] prices, int n) {
		int maxProfit = Integer.MIN_VALUE;
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if(minPrice > prices[i]) 
				minPrice = prices[i];
			if(prices[i] - minPrice > maxProfit)
				maxProfit = prices[i] - minPrice;
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDims = Integer.parseInt(scanner.nextLine());
		String strInput = scanner.nextLine();
		int[] prices = new int[nDims];
		int indx = 0;
		for (String el : strInput.split("\\s+")) {
			prices[indx++] = Integer.parseInt(el);
		}

		int maxProfit = findMaxProfit(prices, nDims);

		System.out.println(maxProfit);

		scanner.close();

	}

}
