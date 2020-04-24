package com.app.questions.read;

public class SingleNumber2Leetcode137 {
	private static int singleNumber(int[] nums) {
		int ones = 0;
		int twos = 0;
		int commonBitMask = 0;
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];

			twos = twos | (ones & x);
			ones = ones ^ x;
			commonBitMask = ~(twos & ones);
			ones = ones & commonBitMask;
			twos = twos & commonBitMask;
		}

		return ones;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 3, 2 };

		int num = singleNumber(nums);

		System.out.println(num);

		nums = new int[] { 0, 1, 0, 1, 0, 1, 99 };

		num = singleNumber(nums);

		System.out.println(num);

	}

}
