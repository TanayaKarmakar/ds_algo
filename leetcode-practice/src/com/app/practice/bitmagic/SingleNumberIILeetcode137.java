package com.app.practice.bitmagic;

public class SingleNumberIILeetcode137 {
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

		System.out.println(singleNumber(nums));

		nums = new int[] { 0, 1, 0, 1, 0, 1, 99 };
		
		System.out.println(singleNumber(nums));

	}

}
