package com.app.dp2.problems;

import java.util.Scanner;

public class SubsetSumSpaceOptimizedDP {
	private static boolean isSubsetSum(int[] num, int sum) {
		int n = num.length;
		boolean[] dp = new boolean[sum + 1];
		
		dp[0] = true;
		for(int i = 1; i <= sum; i++) {
			if(i == num[0]) {
				dp[i] = true;
			}
		}
		
		for(int i = 1; i < n; i++) {
			for(int s = sum; s > 0; s--) {
				if(s >= num[i]) {
					dp[s] = dp[s] || dp[s - num[i]];
				}
			}
		}
		return dp[sum];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int nDim = scanner.nextInt();
		int[] nums = new int[nDim];
		
		for(int i = 0; i < nDim; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int sum = scanner.nextInt();
		
		boolean ans = isSubsetSum(nums, sum);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
