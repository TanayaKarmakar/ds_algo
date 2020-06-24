package com.app.dpbitmasking.problems;

import java.util.Arrays;

public class MinCostJobScheduling {
	private static int minCost(int[][] cost, int n, int p, int mask) {
		if (p >= n)
			return 0;
		int minimum = Integer.MAX_VALUE;
		for (int i = 0; i < cost[0].length; i++) {
			if ((mask & (1 << i)) == 0) {
				int ans = minCost(cost, n, p + 1, (mask | (1 << i)))
						+ cost[p][i];
				if (ans < minimum)
					minimum = ans;
			}
		}
		return minimum;
	}

	private static int minCost(int[][] cost) {
		int n = cost.length;
		return minCost(cost, n, 0, 0);
	}
	
	private static int minCostMemo(int[] dp, int[][] cost, int n, 
			int p, int mask) {
		if(p >= n)
			return 0;
		if(dp[mask] != Integer.MAX_VALUE)
			return dp[mask];
		int minimum = Integer.MAX_VALUE;
		for(int i = 0; i < cost[0].length; i++) {
			if((mask & (1 << i)) == 0) {
				int ans = minCostMemo(dp, cost, n, p + 1, (mask |(1 << i)))
						+ cost[p][i];
				if(ans < minimum) {
					minimum = ans;
				}
			}
		}
		dp[mask] = minimum;
		return minimum;
	}
	
	private static int minCostMemo(int[][] cost) {
		int n = cost.length;
		int m = cost[0].length;
		
		int[] dp = new int[1 << m];
		Arrays.fill(dp, Integer.MAX_VALUE);
		return minCostMemo(dp, cost, n, 0, 0);
	}
	
	private static int minCostI(int[][] cost) {
		int n = cost[0].length;
		int[] dp = new int[(1 << n)];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		for(int mask = 0; mask < ((1 << n) - 1); mask++) {
			int tmp = mask;
			int k = 0;
			while(tmp != 0) {
				k++;
				tmp = tmp & (tmp - 1);
			}
			for(int j = 0; j < n; j++) {
				if((mask & (1 << j)) == 0) {
					dp[(mask | (1 << j))] =
							Integer.min(dp[(mask | (1 << j))], dp[mask] + cost[k][j]);
				}
			}
		}
		return dp[(1 << n) - 1];
	}

	public static void main(String[] args) {
		int[][] cost = { 
				{ 10, 12, 1, 14 }, 
				{ 15, 2, 28, 30 }, 
				{ 45, 30, 15, 3 }, 
				{ 10, 8, 19, 61 } 
			};
		
		int minCost = minCost(cost);
		
		System.out.println("MinCost - " + minCost);
		
		minCost = minCostMemo(cost);
		
		System.out.println("MinCostMemo - " + minCost);
		
		minCost = minCostI(cost);
		
		System.out.println("MinCostIterative - " + minCost);

	}

}
