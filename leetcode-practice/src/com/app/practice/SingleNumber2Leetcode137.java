package com.app.practice;

public class SingleNumber2Leetcode137 {
	private static int singleNumber(int[] nums) {
		int seenOnce = 0;
		int seenTwice = 0;

		for (int num : nums) {
			seenOnce = ~seenTwice & (seenOnce ^ num);
			seenTwice = ~seenOnce & (seenTwice ^ num);
		}

		return seenOnce;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 3, 2 };
		int num = singleNumber(nums);
		
		System.out.println(num);
	}

}
