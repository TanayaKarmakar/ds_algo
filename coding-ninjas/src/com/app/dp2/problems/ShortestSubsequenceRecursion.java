package com.app.dp2.problems;

import java.util.Scanner;

public class ShortestSubsequenceRecursion {
	private static int MAX = 1005;
	private static int findIndx(char ch, String str2, int start) {
		int i = 0;
		for (i = start; i < str2.length(); i++) {
			if (str2.charAt(i) == ch)
				break;
		}
		return i;
	}

	private static int shortestSubsequence(String str1, String str2, int i, int j) {
		if (i == str1.length())
			return MAX;
		if (j == str2.length())
			return 1;
		int k = j;
		int n = str2.length();

		for (; k < n; k++) {
			if (str2.charAt(k) == str1.charAt(i))
				break;
		}

		if (k == n)
			return 1;
		int option1 = shortestSubsequence(str1, str2, i + 1, j);
		int option2 = 1 + shortestSubsequence(str1, str2, i + 1, k + 1);
		return Integer.min(option1, option2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();

		int ans = shortestSubsequence(str1, str2, 0, 0);

		System.out.println(ans);

		scanner.close();

	}

}
