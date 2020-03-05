package com.app.questions;

import java.util.Arrays;

public class NumberSmallerThanCurrent {
	private static int[] smallerThanCurrent(int[] nums) {
		int max = Integer.MIN_VALUE;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] > max)
				max = nums[i];
		}

		int[] count = new int[max + 1];
		for (int i = 0; i < n; i++) {
			count[nums[i]]++;
		}

		for (int i = 1; i <= max; i++) {
			count[i] += count[i - 1];
		}

		for (int i = 0; i < n; i++) {
			int k = nums[i];
			if(k > 0) {
				nums[i] = count[k - 1];
			} else {
				nums[i] = 0;
			}
			
		}

		return nums;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(smallerThanCurrent(new int[] { 8, 1, 2, 2, 3 })));

		System.out.println(Arrays.toString(smallerThanCurrent(new int[] { 6, 5, 4, 8 })));
		
		System.out.println(Arrays.toString(smallerThanCurrent(new int[] { 5,0,10,0,10,6 })));
		
	}

}
