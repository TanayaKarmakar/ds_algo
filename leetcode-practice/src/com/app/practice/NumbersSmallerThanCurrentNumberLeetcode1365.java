package com.app.practice;

import java.util.Arrays;

public class NumbersSmallerThanCurrentNumberLeetcode1365 {
	private static int[] numbersSmallerThanCurrentNumber(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			max = Integer.max(num, max);
		}

		int[] count = new int[max + 1];

		for (int num : nums) {
			count[num]++;
		}

		for (int i = 1; i <= max; i++) {
			count[i] += count[i - 1];
		}

		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int k = nums[i];
			if (k != 0) {
				res[i] = count[k - 1];
			} else {
                res[i] = 0;
            }	
		}


		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 8, 1, 2, 2, 3 };

		System.out.println(Arrays.toString(numbersSmallerThanCurrentNumber(nums)));

		nums = new int[] { 6, 5, 4, 8 };

		System.out.println(Arrays.toString(numbersSmallerThanCurrentNumber(nums)));

		nums = new int[] { 7, 7, 7, 7 };
		
		System.out.println(Arrays.toString(numbersSmallerThanCurrentNumber(nums)));
	}

}
