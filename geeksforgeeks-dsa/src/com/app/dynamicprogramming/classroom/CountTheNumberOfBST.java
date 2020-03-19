package com.app.dynamicprogramming.classroom;

public class CountTheNumberOfBST {
	private static int getCount(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 10;
		for(int i = 1; i <= n; i++) {
			System.out.println("Number of BST with " + i + " nodes " + getCount(i));
		}
	}

}
