package com.app.dpbitmasking.problems;

import java.util.Arrays;

public class JobScheduling {
	private static int minCost(int[][] cost, int mask, int pIndx, int n) {
		if(pIndx >= n)
			return 0;
		int minCost = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			if((mask & (1 << i)) == 0) {
				int ans = minCost(cost, (mask | (1 << i)), pIndx + 1, n) + cost[pIndx][i];
				if(minCost > ans) {
					minCost = ans;
				}
			}
		}
		return minCost;
	}
	
	private static int minCostMemo(int[][] cost, int mask, int pIndx, int n, int[] memo) {
		if(pIndx >= n)
			return 0;
		if(memo[mask] == Integer.MAX_VALUE) {
			int minimum = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++) {
				if((mask & (1 << i)) == 0) {
					int ans = minCostMemo(cost, (mask | (1 << i)), pIndx + 1, n, memo)
							+ cost[pIndx][i];
					if(ans < minimum) {
						minimum = ans;
					}
				}
			}
			memo[mask] = minimum;
		}
		return memo[mask];
	}
	
	private static int jobSchedulingI(int[][] cost, int n) {
		int[] dp = new int[(1 << n)];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int mask = 0; mask < ((1 << n) - 1); mask++) {
			int temp = mask;
			int k = 0;
			while(temp > 0) {
				if(temp % 2 == 1)
					k++;
				temp = temp / 2;
			}
			
			for(int j = 0; j < n; j++) {
				if((mask & (1 << j)) == 0) {
					dp[mask | (1 << j)] = Integer.min(dp[mask | (1 << j)], 
							dp[mask] + cost[k][j]);
				}
			}
		}
		return dp[(1 << n) - 1];
	}

	public static void main(String[] args) {
		int[][] cost = { 
				{ 10, 2, 6, 5 }, 
				{ 1, 15, 12, 8 }, 
				{ 7, 8, 9, 3 }, 
				{ 15, 13, 4, 3 } 
			};
		
		int minCost = minCost(cost, 0, 0, cost.length);
		
		System.out.println(minCost);
		
		int n = cost.length;
		
		int[] dp = new int[1 << n];
		Arrays.fill(dp, Integer.MAX_VALUE);

		minCost = minCostMemo(cost, 0, 0, cost.length, dp);
		
		System.out.println(minCost);
		
		minCost = jobSchedulingI(cost, cost.length);
		
		System.out.println(minCost);
	}

}
