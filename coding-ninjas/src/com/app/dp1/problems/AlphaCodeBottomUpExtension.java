package com.app.dp1.problems;

import java.util.Arrays;
import java.util.Scanner;

public class AlphaCodeBottomUpExtension {
	private static final int MOD = 1000000007;

	private static int numWays(String input, int size) {
		int[] dp = new int[size + 1];
		dp[0] = 1;
		//dp[1] = 1;
		dp[1] = input.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= size; i++) {
			dp[i] = 0;
			if (input.charAt(i - 1) > '0') {
				dp[i] = dp[i - 1] % MOD;
			}
			if (input.charAt(i - 2) == '1' 
					|| (input.charAt(i - 2) == '2' && input.charAt(i - 1) < '7')) {
				dp[i] += dp[i - 2] % MOD;
			}
		}

		// System.out.println(Arrays.toString(dp));
		return dp[size] % MOD;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String input = scanner.nextLine();
			if (input.equals("0"))
				break;
			int totalNum = numWays(input, input.length());
			System.out.println(totalNum);
		}
		scanner.close();

	}

}
