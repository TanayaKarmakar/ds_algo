package com.app.practice.dp;

import java.util.Scanner;

public class UglyNumberIILeetcode264 {
	private static int uglyNumber(int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		
		for(int i = 1; i < n; i++) {
			int ugly2 = dp[i2] * 2;
			int ugly3 = dp[i3] * 3;
			int ugly5 = dp[i5] * 5;
			
			int nextUgly = Integer.min(ugly2, Integer.min(ugly3, ugly5));
			dp[i] = nextUgly;
			if(nextUgly == ugly2)
				i2++;
			if(nextUgly == ugly3)
				i3++;
			if(nextUgly == ugly5)
				i5++;
		}
		
		return dp[n - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int ans = uglyNumber(n);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
