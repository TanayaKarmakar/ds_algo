package com.app.questions;

public class NumberOfStepsLeetcode1342 {
	private static int numberOfSteps(int num) {
		int[] dp = new int[num + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= num; i++) {
			int option1 = dp[i - 1];
			int option2 = 0;
			if(i % 2 == 0) {
				option2 = dp[i / 2];
				option1 = Integer.min(option1, option2);
			}
			dp[i] = 1 + option1;
		}
		
		return dp[num];
	}

	public static void main(String[] args) {
		System.out.println("NumSteps - " + numberOfSteps(14));
		System.out.println("NumSteps - " + numberOfSteps(8));
		System.out.println("NumSteps - " + numberOfSteps(123));
	}

}
