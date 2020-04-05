package com.app.dp2.problems;

import java.util.Arrays;
import java.util.Scanner;

public class BuyAndSellStockTopDown {
	private static int getMaxProfitHelper(int[][][] memo, int[] stocks, int currentIndx, int k, int n, int onGoing) {
		if (currentIndx == n)
			return 0;
		if (memo[currentIndx][k][onGoing] == -1) {
			int option1 = getMaxProfitHelper(memo, stocks, currentIndx + 1, k, n, onGoing);
			int option2 = 0;
			if (onGoing == 1) {
				if (k > 0) {
					//onGoing = 0;
					option2 = getMaxProfitHelper(memo, stocks, currentIndx + 1, k - 1, n, 0) + stocks[currentIndx];
				}
			} else {
				//onGoing = 1;
				option2 = getMaxProfitHelper(memo, stocks, currentIndx + 1, k, n, 1) - stocks[currentIndx];
			}
			memo[currentIndx][k][onGoing] = Integer.max(option1, option2);
		}
		return memo[currentIndx][k][onGoing];
	}

	private static int getMaxProfit(int[] stocks, int k, int n) {
		int[][][] memo = new int[n][k + 1][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= k; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
		return getMaxProfitHelper(memo, stocks, 0, k, n, 0);
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

			int profit = getMaxProfit(stocks, k, nDim);
			System.out.println(profit);
			nTestCases--;
		}
		scanner.close();

	}

}
