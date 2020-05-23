package com.app.questions.dp;

import java.util.Scanner;

public class ReachAGivenScoreGeeksForGeeks {
	private static int reachAGivenScore(int n) {
		int[] dp = new int[n + 1];
		int[] arr = { 3, 5, 10 };
		
		dp[0] = 1;
		for(int i = 0; i < arr.length; i++) {
			for(int j = arr[i]; j <= n; j++) {
				dp[j] += dp[j - arr[i]];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();

		while (nTestCases-- > 0) {
			int n = scanner.nextInt();
			int ans = reachAGivenScore(n);
			System.out.println(ans);
		}
		scanner.close();
	}

}
