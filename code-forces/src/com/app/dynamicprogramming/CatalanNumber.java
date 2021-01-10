package com.app.dynamicprogramming;

import java.util.Arrays;

public class CatalanNumber {
	private static int nThCatalan(int n) {
		if(n == 0 || n == 1)
			return 1;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += (dp[j] * dp[i - j - 1]);
			}
		}
		
		System.out.println(Arrays.toString(dp));
		
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 3;
		int ans = nThCatalan(n);
		
		System.out.println(ans);

	}

}
