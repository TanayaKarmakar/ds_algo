package com.app.dp1.problems;

public class MinimumNumberOfChocolates {
	private static int getMin(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		dp[0] = 1;
		for(int i = 1; i < n; i++) {
			if(arr[i] > arr[i - 1]) {
				dp[i] = 1 + dp[i - 1];
			} else {
				dp[i] = 1;
			}
		}
		
		for(int i = n - 2; i >= 0; i--) {
			if(arr[i] > arr[i + 1] && dp[i] <= dp[i + 1]) {
				dp[i] = 1 + dp[i + 1];
			}
		}
				
		int total = 0;
		for(int el: dp) {
			total += el;
		}
		
		return total;
	}

	public static void main(String[] args) {
		int[] nums = {1,4,4,6};
		
		int min = getMin(nums);
		
		System.out.println(min);

	}

}
