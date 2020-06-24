package com.app.dpbitmasking.problems;

import java.util.Arrays;
import java.util.Scanner;

public class Dilemma {
	private static int finalTouches(int[][] dp, int mask, int pos, int n, String[] input) {
		if ((mask & (mask - 1)) == 0)
			return 0;
		if (pos < 0)
			return 10000;
		if (dp[pos][mask] != Integer.MAX_VALUE)
			return dp[pos][mask];
		int mask1 = 0;
		int mask2 = 0;
		int touches = 0;
		for (int i = 0; i < n; i++) {
			if ((mask & (1 << i)) != 0) {
				touches++;
				if (input[i].charAt(pos) == '0') {
					mask1 |= (1 << i);
				} else {
					mask2 |= (1 << i);
				}
			}
		}
		int ans1 = finalTouches(dp, mask1, pos - 1, n, input) + finalTouches(dp, mask2, pos - 1, n, input) + touches;
		int ans2 = finalTouches(dp, mask, pos - 1, n, input);
		int ans = Integer.min(ans1, ans2);
		dp[pos][mask] = ans;
		return ans;
	}

	private static int minTouches(int n, String[] input) {
		int mask = (1 << n) - 1;
		int[][] dp = new int[input[0].length()][(1 << (n + 1))];
		for (int i = 0; i < dp.length; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		return finalTouches(dp, mask, input[0].length() - 1, n, input);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		String[] strings = new String[n];
		for (int i = 0; i < n; i++) {
			strings[i] = scanner.next();
		}

		int minTouches = minTouches(n, strings);
		System.out.println(minTouches);
		scanner.close();
	}

}
