package com.app.questions.practice;

public class FindMissingPositiveLeetcode41 {

	private static int findMissingPositive(int[] nums) {
		int i = -1;
		int n = nums.length;
		for (int j = 0; j < n; j++) {
			if (nums[j] <= 0) {
				// i++;
				nums[j] = n + 1;
			}
		}

		for (i = 0; i < n; i++) {
			int k = Math.abs(nums[i]);
			if (k - 1 < n && nums[k - 1] > 0) {
				nums[k - 1] = -nums[k - 1];
			}
		}

		for (i = 0; i < n; i++) {
			if (nums[i] > 0)
				return (i + 1);
		}

		return (n + 1);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 0 };
		System.out.println(findMissingPositive(nums));

		nums = new int[] { 3, 4, -1, 1 };
		System.out.println(findMissingPositive(nums));

		nums = new int[] { 7, 8, 9, 11, 12 };
		System.out.println(findMissingPositive(nums));
	}

}
