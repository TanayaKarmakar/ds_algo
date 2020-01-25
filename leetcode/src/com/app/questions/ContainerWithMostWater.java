package com.app.questions;

public class ContainerWithMostWater {
	private static int containerWithMostWater(int[] height) {
		int low = 0;
		int high = height.length - 1;
		
		int max = 0;

		while (low < high) {
			max = Integer.max(max, Integer.min(height[low], height[high])* (high - low)) ;
			if(height[low] < height[high])
				low++;
			else
				high--;
		}
		return max;
	}

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		System.out.println("Water trapped - " + containerWithMostWater(height));

	}

}
