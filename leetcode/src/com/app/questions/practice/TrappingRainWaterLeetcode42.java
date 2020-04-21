package com.app.questions.practice;

public class TrappingRainWaterLeetcode42 {
	private static int trapRainWater(int[] nums) {
		int n = nums.length;
		int left = 0;
		int right = n - 1;
		int lMax = 0;
		int rMax = 0;
		int total = 0;

		while (left < right) {
			if (nums[left] < nums[right]) {
				if (lMax < nums[left]) {
					lMax = nums[left];
				} else {
					total += (lMax - nums[left]);
				}
				left++;
			} else {
				if (rMax < nums[right]) {
					rMax = nums[right];
				} else {
					total += (rMax - nums[right]);
				}
				right--;
			}
		}
		return total;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int total = trapRainWater(nums);
		
		System.out.println("Total - " + total);
	}

}
