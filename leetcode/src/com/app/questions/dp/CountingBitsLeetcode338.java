package com.app.questions.dp;

import java.util.Arrays;

public class CountingBitsLeetcode338 {
	private static int[] countingBits(int num) {
		int[] dp = new int[num + 1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= num; i++) {
			if(i % 2 == 0) {
				dp[i] = dp[i / 2];
			} else {
				dp[i] = dp[i / 2] + 1;
			}
		}
		
		return dp;
	}

	public static void main(String[] args) {
		int num = 15;
		
		int[] res = countingBits(num);
		
		System.out.println(Arrays.toString(res));

	}

}
