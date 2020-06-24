package com.app.dpbitmasking.problems;

import java.util.Scanner;

public class Candy {
	private static int totalWays(int[][] likes, int n) {
		int[] dp = new int[(1 << n)];
		
		dp[0] = 1;
		for(int mask = 0; mask < ((1 << n) - 1); mask++) {
			int tmp = mask;
			int k = 0;
			while(tmp != 0) {
				k++;
				tmp = tmp & (tmp - 1);
			}
			
			for(int j = 0; j < n; j++) {
				if((mask & (1 << j)) == 0 && likes[k][j] == 1) {
					dp[(mask | (1 << j))] += dp[mask];
				}
			}
		}
		
		return dp[(1 << n) - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[][] likes = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				likes[i][j] = scanner.nextInt();
			}
		}
		
		int totalWays = totalWays(likes, n);
		
		System.out.println(totalWays);

		scanner.close();
	}

}
