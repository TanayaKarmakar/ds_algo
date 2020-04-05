package com.app.dp2.problems;

import java.util.Scanner;

public class BuyAndSellStockAtMostKTimesRecursion {
	private static int getMaxProfit(int[] stocks, int currentIndx, int k, boolean onGoing) {
		if (currentIndx == stocks.length) {
			return 0;
		} else {
			int option1 = getMaxProfit(stocks, currentIndx + 1, k, onGoing);
			int option2 = 0;
			if (onGoing) {
				if (k > 0) {
					option2 = getMaxProfit(stocks, currentIndx + 1, k - 1, false) + stocks[currentIndx];
				}
			} else {
				option2 = getMaxProfit(stocks, currentIndx + 1, k, true) - stocks[currentIndx];
			}
			return Integer.max(option1, option2);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while (nTestCases > 0) {
			int k = scanner.nextInt();
			int nDim = scanner.nextInt();
			int[] stocks = new int[nDim];

			for (int i = 0; i < nDim; i++) {
				stocks[i] = scanner.nextInt();
			}

			int profit = getMaxProfit(stocks, 0, k, false);
			System.out.println(profit);
			nTestCases--;
		}
		scanner.close();
	}

}
