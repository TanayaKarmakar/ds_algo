package com.app.dynamicprogramming.classroom;

public class MinimumNumberOfJumpsRecurison {
	private static int minJump(int[] arr, int n) {
		System.out.println("n - " + n);
		if (n == 1)
			return 0;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i <= n - 2; i++) {
			if (i + arr[i] >= n - 1) {
				int subRes = minJump(arr, i + 1);
				if (subRes != Integer.MAX_VALUE) {
					res = Integer.min(res, subRes + 1);
				}
			}
		}

		System.out.println("Res - " + res);
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 2, 1, 2, 1 };
		
		int minVal = minJump(nums, nums.length);
		
		System.out.println("MinVal - " + minVal);
	}

}
