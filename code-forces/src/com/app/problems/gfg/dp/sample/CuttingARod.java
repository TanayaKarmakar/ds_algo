package com.app.problems.gfg.dp.sample;

import java.util.Scanner;

public class CuttingARod {
	private static int maxProfitRecursion(int rodLen, int[] rods, int[] prices, int indx) {
		if(rodLen == 0 || indx >= rods.length)
			return 0;
		int option1 = maxProfitRecursion(rodLen, rods, prices, indx + 1);
		int option2 = 0;
		if(rodLen >= rods[indx])
			option2 = prices[indx] + maxProfitRecursion(rodLen - rods[indx], rods, prices, indx);
		return Integer.max(option1, option2);
	}
	
	private static int maxProfitRecursion(int rodLen, int[] rods, int[] prices) {
		return maxProfitRecursion(rodLen, rods, prices, 0);
	}
	
	private static int maxProfitTabulation(int rodLen, int[] rods, int[] prices) {
		int n = rods.length;
		int[][] dp = new int[n][rodLen + 1];
		
		for(int i = 0; i < n; i++) {
			for(int j = 1; j <= rodLen; j++) {
				int profit1 = 0;
				if(j >= rods[i]) {
					profit1 = prices[i] + dp[i][j - rods[i]];
				}
				int profit2 = 0;
				if((i - 1) >= 0) {
					profit2 = dp[i - 1][j];
				}
				dp[i][j] = Integer.max(profit1, profit2);
			}
		}
		return dp[rods.length - 1][rodLen];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nLenOfRod = scanner.nextInt();
		
		int nValues = scanner.nextInt();
		int[] rods = new int[nValues];
		int[] prices = new int[nValues];
		
		for(int i = 0; i < nValues; i++) {
			rods[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < nValues; i++) {
			prices[i] = scanner.nextInt();
		}
		
		int maxProfit = maxProfitRecursion(nLenOfRod, rods, prices);
		
		System.out.println("Recursion - " + maxProfit);
		
		maxProfit = maxProfitTabulation(nLenOfRod, rods, prices);
		
		System.out.println("Tabulation - " + maxProfit);
		
		scanner.close();
	}

}
