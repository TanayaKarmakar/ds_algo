package com.app.practice;

public class NumberOfStepsToReduceZeroLeetcode1342 {
	private static int numSteps(int num) {
		int[] dp = new int[num + 1];
		for(int i = 1; i <= num; i++) {
			if(i % 2 == 0) {
				dp[i] = 1 + dp[i / 2];
			} else {
				dp[i] = 1 + dp[i - 1];
			}
		}
		return dp[num];
	}

	public static void main(String[] args) {
		System.out.println(numSteps(8));
		System.out.println(numSteps(14));

	}

}
