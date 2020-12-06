package com.app.array;

import java.util.Random;

public class SampleOffLineData {
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static void sampleOfflineData(int[] nums, int k) {
		int n = nums.length;
		Random rand = new Random();
		for (int i = 0; i < k; i++) {
			int min = i;
			int max = n - 1;
			int randIndx = rand.nextInt(max - min + 1) + min;
			swap(nums, min, randIndx);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 3, 5, 7, 11 };

		int k = 3;

		sampleOfflineData(nums, k);

		for (int i = 0; i < k; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

}
