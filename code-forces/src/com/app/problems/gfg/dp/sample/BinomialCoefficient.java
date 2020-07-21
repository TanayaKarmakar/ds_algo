package com.app.problems.gfg.dp.sample;

public class BinomialCoefficient {
	private static int recursion(int n, int k) {
		if(k == 0 || k == n)
			return 1;
		int coeff = recursion(n - 1, k - 1) + recursion(n - 1, k);
		return coeff;
	}
	
	private static int tabulation(int n, int k) {
		int[][] dp = new int[n + 1][k + 1];
		
		for(int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= k; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		
		return dp[n][k];
	}

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		
		int ans = recursion(n, k);
		
		System.out.println(ans);
		
		ans = tabulation(n, k);
		
		System.out.println(ans);

	}

}
