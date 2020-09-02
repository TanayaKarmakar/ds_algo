package com.app.practice.array;

public class TrappingRainWaterLeetcode42 {
	private static int trap(int[] height) {
		int n = height.length;
		int total = 0;

		int lMax = 0;
		int rMax = 0;
		int left = 0;
		int right = n - 1;

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
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		
		int total = trap(height);
		
		System.out.println("Total - " + total);

	}

}
