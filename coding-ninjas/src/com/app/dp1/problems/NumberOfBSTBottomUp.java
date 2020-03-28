package com.app.dp1.problems;

public class NumberOfBSTBottomUp {
	private static final int MOD = 1000000007;
	
	private static int numOfBST(int n) {
		if(n <= 1)
			return 1;
		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		//dp[2] = 2;
		
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				dp[i] = ((dp[i] % MOD) + ((dp[j] % MOD) * (dp[i - j - 1] % MOD))%MOD)%MOD;
			}
		}
		
		return (int)dp[n];
	}
	
	

	public static void main(String[] args) {
		int n = 3;
		
		System.out.println(numOfBST(n));

	}

}
