package com.app.problems.gfg.dp.sample;

import java.util.Scanner;

public class GoldMineProblem {
	private static int mineMaxGold(int[][] mine, int m, int n) {
		int[][] dp = new int[m][n];
		
		for(int j = n - 1; j >= 0; j--) {
			for(int i = 0; i < m; i++) {
				int right = (j == n - 1)? 0: dp[i][j + 1];
				int rightDown = (i == m - 1 || j == n - 1)? 0: dp[i + 1][j + 1];
				int rightUp = (i == 0 || j == 0)? 0: dp[i - 1][j - 1];
				
				dp[i][j] = mine[i][j] + Integer.max(right, Integer.max(rightDown, rightUp));
			}
		}
		
		int maxValue = Integer.MIN_VALUE;
		
		for(int i = 0; i < m; i++) {
			maxValue = Integer.max(dp[i][0], maxValue);
		}
		
		return maxValue;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		
		int[][] mine = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				mine[i][j] = scanner.nextInt();
			}
		}
		
		int maxGold = mineMaxGold(mine, m, n);
		
		System.out.println(maxGold);
		
		scanner.close();

	}

}
