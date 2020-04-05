package com.app.dp2.problems;

import java.util.Arrays;
import java.util.Scanner;

public class ShortestSubsequenceTopDown {
	private static final int MAX = 1005;

	private static int getAnsHelper(int[][] memo, String str1, String str2, int i, int j) {
		if (i == str1.length())
			return MAX;
		if (j == str2.length())
			return 1;

		if (memo[i][j] == Integer.MAX_VALUE) {
			int k = j;
			int n = str2.length();

			for (; k < n; k++) {
				if (str2.charAt(k) == str1.charAt(i))
					break;
			}

			if (k == n)
				return 1;
			int option1 = getAnsHelper(memo, str1, str2, i + 1, j);
			int option2 = 1 + getAnsHelper(memo, str1, str2, i + 1, k + 1);
			memo[i][j] = Integer.min(option1, option2);

		}
		return memo[i][j];
	}

	private static int getAns(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] memo = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			Arrays.fill(memo[i], Integer.MAX_VALUE);
		}
		return getAnsHelper(memo, str1, str2, 0, 0);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();

		int ans = getAns(str1, str2);

		System.out.println(ans);

		scanner.close();

	}

}
