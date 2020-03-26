package com.app.dp1.problems;

//this solution is fine when there is no zero coming in the input
public class AlphaCodeBottomUp {
	private static int numWays(int[] nums, int size) {
		int[] dp = new int[size + 1];
		dp[0] = 1;
		//dp[1] = 1;
		dp[1] = nums[0] == 0 ? 0 : 1;

		for (int i = 2; i <= size; i++) {
			int output = 0;
			if(nums[i - 1] > 0) {
				output = dp[i - 1];
			}
			if(nums[i - 2] == 1 || (nums[i - 2] == 2 && nums[i - 1] < 7)) {
				output += dp[i - 2];
			}
			dp[i] = output;
		}

		return dp[size];
	}

	public static void main(String[] args) {
		int[] code = { 2, 3, 1, 4 };
		int totalWays = numWays(code, code.length);
		
		System.out.println("TotalWays - " + totalWays);
		
		code = new int[] {3,0,1};
		
		totalWays = numWays(code, code.length);
		
		System.out.println("Totalways - " + totalWays);
		
		code = new int[] {1,0,2,0};
		
		totalWays = numWays(code, code.length);
		
		System.out.println("TotalWays - " + totalWays);

	}

}
