package com.app.practice;

public class TrappingRainWaterLeetcode42 {
	private static int trap(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int lMax = Integer.MIN_VALUE;
		int rMax = Integer.MIN_VALUE;

		int total = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] > lMax) {
					lMax = height[left];
				} else {
					total += (lMax - height[left]);
				}
				left++;
			} else {
				if (height[right] > rMax) {
					rMax = height[right];
				} else {
					total += (rMax - height[right]);
				}
				right--;
			}
		}
		return total;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int total = trap(nums);
		
		System.out.println(total);

	}

}
