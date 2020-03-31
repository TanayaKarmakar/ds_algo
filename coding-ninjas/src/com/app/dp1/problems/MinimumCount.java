package com.app.dp1.problems;

import java.util.Arrays;

public class MinimumCount {
	private static int minCount(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		
		int sqrt = (int)Math.sqrt(n);
		
		int[] arr = new int[sqrt];
		for(int i = 0; i < sqrt; i++) {
			arr[i] = (i + 1);
		}
		
		for(int j = 1; j <= n; j++) {
			for(int i = 0; i < sqrt; i++) {
				if(j >= (arr[i] * arr[i])) {
					int subRes = dp[j - (arr[i] * arr[i])] + 1;
					dp[j] = Integer.min(dp[j], subRes);
				}
			}
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		int min = minCount(12);
		
		System.out.println(min);
		
		min = minCount(9);
		
		System.out.println(min);

	}

}
