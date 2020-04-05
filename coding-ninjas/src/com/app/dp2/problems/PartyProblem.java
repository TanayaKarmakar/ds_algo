package com.app.dp2.problems;

import java.util.Scanner;

public class PartyProblem {
	private static void getOptiomalValueSpaceOptimized(int[] cost, int[] fun, int maxCapacity, int nParties) {
		int[] dp = new int[maxCapacity + 1];
		
		int totalBudgetUsed = 0;
		
		for(int i = 0; i <= maxCapacity; i++) {
			if(i >= cost[0]) {
				dp[i] = fun[0];
				if(totalBudgetUsed == 0) {
					totalBudgetUsed = cost[0];
				}
			}
		}
		
		for(int i = 1; i < nParties; i++) {
			boolean added = false;
			for(int c = maxCapacity; c >= 0; c--) {
				int option1 = dp[c];
				int option2 = 0;
				if(c >= cost[i]) {
					option2 = fun[i] + dp[c - cost[i]];
				}
				if(option2 > option1) {
					dp[c] = option2;
					if(!added) {
						totalBudgetUsed += cost[i];
						added = true;
					}	
				}
			}
		}
		
		System.out.println(totalBudgetUsed + " " + dp[maxCapacity]);
	}
	
	
	private static void getOptimalValue(int[] cost, int[] fun, int maxCapacity, int nParties) {
		int[][] dp = new int[nParties][maxCapacity + 1];

		for (int i = 0; i <= maxCapacity; i++) {
			if (i >= cost[0]) {
				dp[0][i] = fun[0];
			}
		}

		for (int i = 1; i < nParties; i++) {
			for (int j = 1; j <= maxCapacity; j++) {
				int option1 = dp[i - 1][j];
				int option2 = 0;
				if (j >= cost[i]) {
					option2 = fun[i] + dp[i - 1][j - cost[i]];
				}
				dp[i][j] = Integer.max(option1, option2);
			}
		}

		int totalBudgetUsed = 0;
		int maxFun = dp[nParties - 1][maxCapacity];
		int ans = dp[nParties - 1][maxCapacity];

		
		for(int i = nParties - 1; i > 0; i--) {
			if(maxFun != dp[i - 1][maxCapacity]) {
				maxCapacity -= cost[i];
				totalBudgetUsed += cost[i];
				maxFun -= fun[i];
			}
		}
		
		if(maxFun != 0) {
			totalBudgetUsed += cost[0];
		}

		System.out.println(totalBudgetUsed + " " + ans);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			int maxCapacity = scanner.nextInt();
			int nParties = scanner.nextInt();
			if(maxCapacity == 0 && nParties == 0) {
				break;
			}
			else {
				int[] cost = new int[nParties];
				int[] fun = new int[nParties];

				int i = 0;
				while (i < nParties) {
					cost[i] = scanner.nextInt();
					fun[i] = scanner.nextInt();
					i++;
				}
				//getOptimalValue(cost, fun, maxCapacity, nParties);
				getOptiomalValueSpaceOptimized(cost, fun, maxCapacity, nParties);
			}

		}
		scanner.close();
	}

}
