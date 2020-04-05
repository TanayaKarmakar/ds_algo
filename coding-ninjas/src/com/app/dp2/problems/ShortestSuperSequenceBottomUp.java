package com.app.dp2.problems;

import java.util.Scanner;

public class ShortestSuperSequenceBottomUp {
	private static int shortestSuperSequence(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();

		int[][] dp = new int[m + 1][n + 1];
		dp[m][n] = 0;

		for (int i = n - 1; i >= 0; i--) {
			dp[m][i] = 1 + dp[m][i + 1];
		}

		for (int i = m - 1; i >= 0; i--) {
			dp[i][n] = 1 + dp[i + 1][n];
		}

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					int option1 = dp[i + 1][j];
					int option2 = dp[i][j + 1];
					dp[i][j] = 1 + Integer.min(option1, option2);
				}
			}
		}

		//System.out.println(Arrays.deepToString(dp));

		return dp[0][0];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();

		int ans = shortestSuperSequence(str1, str2);

		System.out.println(ans);

		scanner.close();

	}

}
