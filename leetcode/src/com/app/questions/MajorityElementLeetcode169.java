package com.app.questions;

public class MajorityElementLeetcode169 {
	private static int majorityElement(int[] nums) {
		int n = nums.length;

		int majorityEl = nums[0];
		int count = 1;

		for (int i = 1; i < n; i++) {
			if (nums[i] == majorityEl) {
				count++;
			} else {
				count--;
				if (count == 0) {
					majorityEl = nums[i];
					count = 1;
				}
			}
		}

		count = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == majorityEl)
				count++;
		}

		if (count > n / 2)
			return majorityEl;
		else
			return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3 };

		System.out.println(majorityElement(nums));

		nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };
		
		System.out.println(majorityElement(nums));

	}

}
