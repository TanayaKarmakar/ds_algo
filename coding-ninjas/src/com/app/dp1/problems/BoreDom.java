package com.app.dp1.problems;

public class BoreDom {
	private static int maxPoints(int n, int[] arr) {
		int[] freq = new int[1000];

		for (int el : arr) {
			freq[el - 1]++;
		}

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = freq[0];
		for (int i = 2; i <= n; i++) {
			int option1 = dp[i - 1];
			int option2 = 0;
			//if (i - 2 > 0) {
				option2 = dp[i - 2] + i * freq[i - 1];
			//}
			dp[i] = Integer.max(option1, option2);
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int val = maxPoints(9, new int[] { 1, 2, 1, 3, 2, 2, 2, 2, 3 });
		System.out.println(val);

	}

}
