package com.app.practice.greedy;

public class MajorityElementLeetcode169 {
	private static int majorityElement(int[] nums) {
		int mIndx = 0;
		int count = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[mIndx] == nums[i]) {
				count++;
			} else {
				count--;
				if (count == 0) {
					mIndx = i;
					count++;
				}
			}
		}

		count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == nums[mIndx])
				count++;
		}

		if (count > nums.length / 2)
			return mIndx;
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3 };

		int mIndx = majorityElement(nums);

		System.out.println(nums[mIndx]);

		nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };
		
		mIndx = majorityElement(nums);

		System.out.println(nums[mIndx]);

	}

}
