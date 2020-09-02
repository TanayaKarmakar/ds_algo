package com.app.practice.dp;

import java.util.Scanner;

public class NumberOfStepsToReduceTheNumberToZeroLeetcode1342 {
	private static int numSteps(int n) {
		if(n == 0)
			return 0;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		
		for(int i = 1; i <= n; i++) {
			if(i % 2 != 0)
				dp[i] = 1 + dp[i - 1];
			else
				dp[i] = 1 + dp[i / 2];
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int ans = numSteps(n);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
