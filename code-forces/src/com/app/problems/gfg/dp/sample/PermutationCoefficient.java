package com.app.problems.gfg.dp.sample;

public class PermutationCoefficient {
	private static int recursion(int n, int k) {
		if(k > n)
			return 0;
		if(k == 0)
			return 1;
		if(k == 1)
			return n;
		int coeff = recursion(n - 1, k) + k * recursion(n - 1, k - 1);
		return coeff;
	}
	
	private static int tabulation(int n, int k) {
		int[][] dp = new int[n + 1][k + 1];
		
		for(int i = 0; i <= n; i++) {
			dp[i][0] = 1;
			dp[i][1] = i;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 2; j <= k; j++) {
				if(i >= j) {
					dp[i][j] = dp[i - 1][j] + j * dp[i - 1][j - 1];
				}
			}
		}
		
		return dp[n][k];
	}

	public static void main(String[] args) {
		int n = 10;
		int k = 2;
		
		int ans = recursion(n, k);
		System.out.println(ans);
		
		ans = tabulation(n, k);
		System.out.println(ans);
		
		ans = tabulation(10, 1);
		
		System.out.println(ans);

	}

}
