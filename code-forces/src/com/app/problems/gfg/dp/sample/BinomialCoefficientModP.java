package com.app.problems.gfg.dp.sample;

import java.util.Scanner;

public class BinomialCoefficientModP {
	private static int findValue(int n, int r, int p) {
		if(r > n)
			r = r - n;
		int[][] dp = new int[n + 1][r + 1];
		
		for(int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= r; j++) {
				if(i == j) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i - 1][j] % p + dp[i - 1][j - 1] % p) % p;
				}
			}
		}
		
		return dp[n][r];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int r = scanner.nextInt();
		
		int p = scanner.nextInt();
		
		int ans = findValue(n, r, p);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
