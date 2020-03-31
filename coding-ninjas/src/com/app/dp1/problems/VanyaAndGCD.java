package com.app.dp1.problems;

import java.util.Scanner;

public class VanyaAndGCD {
	private static final int MOD = 1000000007;
	
	private static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
	
	private static int totalCount(int[] nums) {
		int n = nums.length;
		int totalNum = 100;

		int[][] dp = new int[n][totalNum + 1];
		//System.out.println(dp.length);
		for (int i = 1; i < n; i++) {
			//System.out.println(i);
			dp[i][nums[i]] = 1;
			for(int j = 1; j < i; j++) {
				if(nums[i] <= nums[j])
					continue;
				for(int k = 1; k <= nums[j]; k++) {
					int g = gcd(nums[i], k);
					dp[i][g] = ((dp[i][g] % MOD) + (dp[j][k] % MOD)) % MOD;
				}
			}
		}
		
		int ans = 0;
		for(int i = 1; i< n; i++) {
			ans = ((ans % MOD) + (dp[i][1] % MOD))%MOD;
		}
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int nDim = scanner.nextInt();
		int []nums = new int[nDim + 1];
		nums[0] = -1;
		for(int i = 1; i <= nDim; i++) {
			nums[i] = scanner.nextInt();
		}

		int totalCount = totalCount(nums);
		
		System.out.println(totalCount);
		
		scanner.close();
	}

}
