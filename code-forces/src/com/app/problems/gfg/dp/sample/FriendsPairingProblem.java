package com.app.problems.gfg.dp.sample;

public class FriendsPairingProblem {
	private static int recursion(int n) {
		if (n < 0)
			return 0;
		if (n == 0 || n == 1)
			return 1;
		int smallOutput = recursion(n - 1) + (n - 1) * recursion(n - 2);
		return smallOutput;
	}

	private static int tabulation(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 3;
		int ans = recursion(n);

		System.out.println(ans);
		
		ans = tabulation(n);
		
		System.out.println(ans);

	}

}
