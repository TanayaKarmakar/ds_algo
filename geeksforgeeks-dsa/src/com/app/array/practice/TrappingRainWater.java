package com.app.array.practice;

public class TrappingRainWater {
	private static int trapRainWater(int[] arr) {
		int n = arr.length;
		int left = 0;
		int right = n - 1;
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;

		int sum = 0;

		while (left <= right) {
			if (arr[left] < arr[right]) {
				if (arr[left] > leftMax) {
					leftMax = arr[left];
				} else {
					sum += (leftMax - arr[left]);
				}
				left++;
			} else {
				if (arr[right] > rightMax) {
					rightMax = arr[right];
				} else {
					sum += (rightMax - arr[right]);
				}
				right--;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TC1
		System.out.println("Trapped water - " + trapRainWater(new int[] { 3, 0, 0, 2, 0, 4 }));

		// TC2
		System.out.println("Trapper water - " + trapRainWater(new int[] { 4, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}

}
