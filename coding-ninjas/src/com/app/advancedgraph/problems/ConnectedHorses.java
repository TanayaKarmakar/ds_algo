package com.app.advancedgraph.problems;

import java.util.Scanner;

public class ConnectedHorses {
	private static final int MAX = 1000001;
	private static final int MOD = 1000000007;
	private static long[] dp = new long[MAX];

	private static void preCalc() {
		dp[0] = 1;
		for (int i = 1; i < MAX; i++) {
			dp[i] = (dp[i - 1] * i) % MOD;
		}
	}

	private static int bfs(int[][] mat, int i, int j, int n, int m) {
		int total = 1;
		mat[i][j] = 2;

		if (i - 2 >= 1 && j + 1 <= m && mat[i - 2][j + 1] == 1) {
			total += bfs(mat, i - 2, j + 1, n, m);
		}
		if (i - 2 >= 1 && j - 1 >= 1 && mat[i - 2][j - 1] == 1) {
			total += bfs(mat, i - 2, j - 1, n, m);
		}
		if (i + 2 <= n && j + 1 <= m && mat[i + 2][j + 1] == 1) {
			total += bfs(mat, i + 2, j + 1, n, m);
		}
		if (i + 2 <= n && j - 1 >= 1 && mat[i + 2][j - 1] == 1) {
			total += bfs(mat, i + 2, j - 1, n, m);
		}
		////////////////////////////////////////////////////////
		if (i - 1 >= 1 && j + 2 <= m && mat[i - 1][j + 2] == 1) {
			total += bfs(mat, i - 1, j + 2, n, m);
		}
		if (i - 1 >= 1 && j - 2 >= 1 && mat[i - 1][j - 2] == 1) {
			total += bfs(mat, i - 1, j - 2, n, m);
		}
		if (i + 1 <= n && j + 2 <= m && mat[i + 1][j + 2] == 1) {
			total += bfs(mat, i + 1, j + 2, n, m);
		}
		if (i + 1 <= n && j - 2 >= 1 && mat[i + 1][j - 2] == 1) {
			total += bfs(mat, i + 1, j - 2, n, m);
		}
		return total;
	}

	private static long getTotal(int[][] mat, int n, int m) {
		long ans = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (mat[i][j] == 1) {
					int total = bfs(mat, i, j, n, m);
					ans = (ans * dp[total]) % MOD;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		preCalc();
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while (nTestCases > 0) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int q = scanner.nextInt();
			int[][] mat = new int[n + 1][m + 1];
			while (q > 0) {
				int i = scanner.nextInt();
				int j = scanner.nextInt();
				mat[i][j] = 1;
				q--;
			}
			long ans = getTotal(mat, n, m);
			System.out.println(ans);
			nTestCases--;
		}
		scanner.close();
	}

}
