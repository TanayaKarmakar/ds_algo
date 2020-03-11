package com.app.dynamicprogramming.classroom;

import java.util.Arrays;

public class MinimumNumberOfJumpsTabulation {
	private static int minJumps(int[] arr, int n) {
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (j + arr[j] >= i) {
					if (dp[j] != Integer.MAX_VALUE) {
						dp[i] = Integer.min(dp[i], dp[j] + 1);
					}
				}
			}
		}

		//System.out.println(Arrays.toString(dp));
		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 2, 1, 2, 1 };
		int minJump = minJumps(arr, arr.length);

		System.out.println("MinJump - " + minJump);
	}

}
