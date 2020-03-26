package com.app.dp1.problems;

public class AlphaCodeTopDown {
	private static int numWays(int[] memo, int[] nums, int size) {
		if (size == 0)
			return 1;
		if(size == 1) {
			if(nums[0] == 0)
				return 0;
			else
				return 1;
		}
		if (memo[size] > 0)
			return memo[size];
		int output = numWays(memo, nums, size - 1);
		if (nums[size - 2] * 10 + nums[size - 1] <= 26)
			output += numWays(memo, nums, size - 2);
		return output;
	}

	private static int numWays(int[] nums, int size) {
		int[] memo = new int[size + 1];
		return numWays(memo, nums, size);
	}

	public static void main(String[] args) {
		//int[] code = { 2, 3, 1, 4 };
		int[] code = {0, 1};
		int totalWays = numWays(code, code.length);
		
		System.out.println("TotalWays - " + totalWays);

	}

}
