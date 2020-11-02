package com.app.practice.dp;

import java.util.Scanner;

public class NumberOfStepsToReduceToZero {
	private static int numberOfSteps(int num) {
		if(num == 0) return 0;
		int[] dp = new int[num + 1];
		dp[1] = 1;
		for (int i = 2; i <= num; i++) {
			if (i % 2 == 0)
				dp[i] = dp[i / 2] + 1;
			else
				dp[i] = dp[i - 1] + 1;
		}

		return dp[num];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		int ans = numberOfSteps(num);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
