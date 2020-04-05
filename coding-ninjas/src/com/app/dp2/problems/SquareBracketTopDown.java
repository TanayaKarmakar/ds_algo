package com.app.dp2.problems;

import java.util.Arrays;
import java.util.Scanner;

public class SquareBracketTopDown {
	private static int getCountHelper(int[][] memo, int n, int oCount, int cCount, boolean[] bIndices) {
		if (oCount > n || cCount > n)
			return 0;
		if (oCount == n && cCount == n)
			return 1;
		if (memo[oCount][cCount] == -1) {
			if (oCount == cCount || bIndices[oCount + cCount] == true) {
				memo[oCount][cCount] = getCountHelper(memo, n, oCount + 1, cCount, bIndices);
			} else if (oCount == n) {
				memo[oCount][cCount] = getCountHelper(memo, n, oCount, cCount + 1, bIndices);
			} else {
				memo[oCount][cCount] = getCountHelper(memo, n, oCount + 1, cCount, bIndices)
						+ getCountHelper(memo, n, oCount, cCount + 1, bIndices);
			}
		}
		return memo[oCount][cCount];
	}

	private static int getValidCombinationCount(int n, boolean[] bIndices) {
		int[][] memo = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(memo[i], -1);
		}
		return getCountHelper(memo, n, 0, 0, bIndices);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDataSets = scanner.nextInt();

		while (nDataSets > 0) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			boolean[] bIndices = new boolean[2 * n];
			for (int i = 0; i < k; i++) {
				int val = scanner.nextInt();
				bIndices[val - 1] = true;
			}
			int nCombinations = getValidCombinationCount(n, bIndices);
			System.out.println(nCombinations);
			nDataSets--;
		}
		scanner.close();

	}

}
