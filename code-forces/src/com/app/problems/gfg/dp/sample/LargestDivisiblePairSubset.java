package com.app.problems.gfg.dp.sample;

import java.util.Arrays;
import java.util.Scanner;

public class LargestDivisiblePairSubset {
	private static int largestDivisiblePair(int[] nums, int n) {
		int[] dp = new int[n];
		
		Arrays.sort(nums);
		
		int maxLen = Integer.MIN_VALUE;
		
		dp[0] = 1;
		for(int i = 1; i < n; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[i] % nums[j] == 0) {
					dp[i] = Integer.max(dp[i], dp[j] + 1);
					maxLen = Integer.max(maxLen, dp[i]);
				}
			}
		}
		
		return maxLen;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int ans = largestDivisiblePair(nums, n);
		
		System.out.println(ans);

		scanner.close();
	}

}
