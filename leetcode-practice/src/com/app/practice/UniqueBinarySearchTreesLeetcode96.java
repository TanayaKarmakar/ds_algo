package com.app.practice;

public class UniqueBinarySearchTreesLeetcode96 {
	private static int countTrees(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		for(int i = 1; i < 10; i++) {
			System.out.println(countTrees(i));
		}
	}

}
