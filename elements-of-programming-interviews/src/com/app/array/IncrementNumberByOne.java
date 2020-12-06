package com.app.array;

import java.util.Arrays;

public class IncrementNumberByOne {
	private static int[] increment(int[] nums) {
		int n = nums.length;
		int[] result = new int[n + 1];
		int num = nums[n - 1];
		int carry = 0;
		int sum = num + 1;
		if (sum > 9) {
			carry = sum / 10;
			sum = sum % 10;
		}
		result[n] = sum;
		for (int i = n - 2; i >= 0; i--) {
			sum = nums[i];
			if (carry > 0) {
				sum += carry;
			}
			if (sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			result[i + 1] = sum;
		}

		if (carry > 0)
			result[0] = carry;
		if (result[0] == 0)
			return Arrays.copyOfRange(result, 1, result.length);
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 9 };

		int[] result = increment(nums);

		System.out.println(Arrays.toString(result));

		nums = new int[] { 9, 9, 9 };

		result = increment(nums);

		System.out.println(Arrays.toString(result));

	}

}
