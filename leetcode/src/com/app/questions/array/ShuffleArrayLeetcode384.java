package com.app.questions.array;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArrayLeetcode384 {
	int[] nums;
	final int[] origNums;
	Random rand;

	public ShuffleArrayLeetcode384(int[] nums) {
		this.nums = nums;
		this.origNums = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			origNums[i] = nums[i];
		}
		rand = new Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return this.origNums == null ? new int[]{}: this.origNums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		if(nums.length == 0)
            return new int[]{};
		int min = 0;
		int max = nums.length - 1;
		int randIndx = rand.nextInt(max - min + 1);
		swap(nums, randIndx, 0);
		return nums;
	}
	
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public static void main(String[] args) {
		ShuffleArrayLeetcode384 obj = new ShuffleArrayLeetcode384(new int[] { 1, 2, 3 });
		System.out.println(Arrays.toString(obj.shuffle()));
		System.out.println(Arrays.toString(obj.shuffle()));
	}

}
