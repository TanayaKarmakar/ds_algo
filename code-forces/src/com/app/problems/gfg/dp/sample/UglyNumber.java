package com.app.problems.gfg.dp.sample;

public class UglyNumber {
	private static int uglyNumber(int n) {
		int[] dp = new int[n];
		
		dp[0] = 1;
		int mul2 = dp[0] * 2;
		int mul3 = dp[0] * 3;
		int mul5 = dp[0] * 5;
		
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		
		for(int i = 1; i < n; i++) {
			int ugly = Integer.min(mul2, Integer.min(mul3, mul5));
			
			dp[i] = ugly;
			
			if(ugly == mul2) {
				i2++;
				mul2 = dp[i2] * 2;
			}
			if(ugly == mul3) {
				i3++;
				mul3 = dp[i3] * 3;
			}
			if(ugly == mul5) {
				i5++;
				mul5 = dp[i5] * 5;
			}
		}
		
		return dp[n - 1];
	}

	public static void main(String[] args) {
		int n = 7;
		
		System.out.println(uglyNumber(n));
		
		n = 10;
		
		System.out.println(uglyNumber(n));
		
		n = 15;
		
		System.out.println(uglyNumber(n));

	}

}
