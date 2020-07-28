package com.app.problems.gfg.dp.sample;

import java.util.Scanner;

public class SubsetSumDivisibleByM {
	private static boolean tabulation(int[] nums, int m) {
		int n = nums.length;
		if(n > m)
			return true;
		
		boolean[] dp = new boolean[m];
		
		for(int i = 0; i < n; i++) {
			if(dp[0])
				return true;
			boolean[] temp = new boolean[m];
			for(int j = 0; j < m; j++) {
				if(dp[j]) {
					if(dp[(j + nums[i]) % m] == false)
						temp[(j + nums[i]) % m] = true;
				}
			}
			
			for(int j = 0; j < m; j++) {
				if(temp[j])
					dp[j] = true;
			}
			
			dp[nums[i] % m] = true;
		}
		
		return dp[0];
	}
	
	private static boolean recHelper(int[] nums, int m, int indx, int sum) {
		if((sum != 0 && sum % m == 0) || nums.length == 0)
			return true;
		if(indx >= nums.length)
			return false;
		int sum1 = sum;
		boolean option1 = recHelper(nums, m, indx + 1, sum1);
		boolean option2 = recHelper(nums, m, indx + 1, sum1 + nums[indx]);
		return option1 || option2;
	}
	
	private static boolean recursion(int[] nums, int m) {
		return recHelper(nums, m, 0, 0);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int m = scanner.nextInt();
		
		boolean ans = recursion(nums, m);
		
		System.out.println(ans);
		
		ans = tabulation(nums, m);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
