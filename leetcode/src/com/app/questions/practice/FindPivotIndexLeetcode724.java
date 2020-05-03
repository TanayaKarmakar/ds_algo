package com.app.questions.practice;

public class FindPivotIndexLeetcode724 {
	private static int pivotIndx(int[] nums) {
		int totalSum = 0;
		for (int el : nums) {
			totalSum += el;
		}

		int leftSum = 0;
		int rightSum = totalSum;

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (i - 1 >= 0)
				leftSum += nums[i - 1];
			rightSum -= nums[i];
			if (leftSum == rightSum)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 7, 3, 6, 5, 6 };
		
		int pivotIndx = pivotIndx(nums);
		
		System.out.println(pivotIndx);
		
		nums = new int[] {1, 2, 3};
		
		pivotIndx = pivotIndx(nums);
		
		System.out.println(pivotIndx);
		
		nums = new int[] {};
		
		pivotIndx = pivotIndx(nums);
		
		System.out.println(pivotIndx);
		
		nums = new int[] {10};
		
		pivotIndx = pivotIndx(nums);
		
		System.out.println(pivotIndx);

	}

}
