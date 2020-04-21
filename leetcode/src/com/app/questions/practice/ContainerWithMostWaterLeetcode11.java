package com.app.questions.practice;

public class ContainerWithMostWaterLeetcode11 {
	private static int containerWithMostWater(int[] heights) {
		int low = 0;
		int high = heights.length - 1;

		int maxArea = 0;

		while (low < high) {
			int minHeight = Integer.min(heights[high], heights[low]);
			maxArea = Integer.max(maxArea, minHeight * (high - low));
			if (heights[low] < heights[high])
				low++;
			else
				high--;
		}

		return maxArea;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int maxArea = containerWithMostWater(arr);
		
		System.out.println(maxArea);
	}

}
