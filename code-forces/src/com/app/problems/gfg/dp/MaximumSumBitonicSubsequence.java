package com.app.problems.gfg.dp;

import java.util.Scanner;

public class MaximumSumBitonicSubsequence {
	private static int maxSum(int[] nums, int n) {
		int[] lis = new int[n];
		int[] lds = new int[n];
		
		lis[0] = nums[0];
		
		for(int i = 1; i < n; i++) {
			lis[i] = nums[i];
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					lis[i] = Integer.max(lis[i], lis[j] + nums[i]);
				}
			}
		}
		
		lds[n - 1] = nums[n - 1];
		for(int i = n - 2; i >= 0; i--) {
			lds[i] = nums[i];
			for(int j = n - 1; j > i; j--) {
				if(nums[j] < nums[i]) {
					lds[i] = Integer.max(lds[i], lds[j] + nums[i]);
				}
			}
		}
		
		int maxSum = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			maxSum = Integer.max(maxSum, lis[i] + lds[i] - nums[i]);
		}
		
		return maxSum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			int[] nums = new int[n];
			for(int i = 0;i < n; i++) {
				nums[i] = scanner.nextInt();
			}
			
			int maxSum = maxSum(nums, n);
			System.out.println(maxSum);
		}
		scanner.close();

	}

}
