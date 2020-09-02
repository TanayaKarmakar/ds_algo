package com.app.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class CountingBitsLeetcode338 {
	private static int[] countBits(int n) {
		if(n == 0) {
			return new int[] {0};
		} else if(n == 1) {
			return new int[] {0, 1};
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			if((i % 2) == 0) {
				dp[i] = dp[i / 2];
			} else {
				dp[i] = dp[i - 1] + 1;
				//dp[i] = dp[i / 2] + 1
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int[] res = countBits(n);
		
		System.out.println(Arrays.toString(res));
		
		scanner.close();

	}

}
