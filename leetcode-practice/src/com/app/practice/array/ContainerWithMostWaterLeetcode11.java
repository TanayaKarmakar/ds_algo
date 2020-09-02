package com.app.practice.array;

public class ContainerWithMostWaterLeetcode11 {
	private static int maxArea(int[] height) {
		int n = height.length;
		int l = 0;
		int r = (n - 1);

		int maxArea = 0;
		while (l < r) {
			maxArea = Integer.max(maxArea, 
					Integer.min(height[l], height[r]) * (r - l));

			if (height[l] < height[r])
				l++;
			else
				r--;
		}

		return maxArea;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		
		int maxArea = maxArea(nums);
		
		System.out.println(maxArea);

	}

}
