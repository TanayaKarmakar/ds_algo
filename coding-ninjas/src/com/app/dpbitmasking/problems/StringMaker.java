package com.app.dpbitmasking.problems;

import java.util.Arrays;
import java.util.Scanner;

public class StringMaker {
	private static final int MOD = 1000000007;
	
	private static int solve(long[][][] dp, String a, String b, String c) {
		int n1 = a.length();
		int n2 = b.length();
		int n3 = c.length();
		if(n3 == 0)
			return 1;
		if(n1 <= 0 && n2 <= 0)
			return 0;
		int count = 0;
		for(int i = 0; i < n1; i++) {
			if(a.charAt(i) == c.charAt(0)) {
				count += solve(dp, a.substring(i + 1), b, c.substring(1));
			}
		}
		
		for(int j = 0; j < n2; j++) {
			if(b.charAt(j) == c.charAt(0)) {
				count += solve(dp, a, b.substring(j + 1), c.substring(1));
			}
		}
		dp[n1][n2][n3] = count % MOD;
		return (count % MOD);
	}
	
	private static int solve(String a, String b, String c) {
		long[][][] dp = new long[100][100][100];
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				for(int k = 0; k < 100; k++) {
					Arrays.fill(dp[i][j], -1);
				}
			}
		}
		return solve(dp, a, b, c);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String a = scanner.next();
		String b = scanner.next();
		String c = scanner.next();
		
		int count = solve(a, b, c);
		
		System.out.println(count);
		
		scanner.close();

	}

}
