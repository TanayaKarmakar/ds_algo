package com.app.sorting;

import java.util.Arrays;

public class SmallestNonConstructibleValue {
	private static int smallestNonConstructibleValue(int[] nums) {
		Arrays.sort(nums);

		int maxConstructibleValue = 0;
		for (int num : nums) {
			if (num > maxConstructibleValue + 1)
				break;
			maxConstructibleValue += num;
		}

		return maxConstructibleValue + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 12, 2, 1, 15, 2, 4 };
		
		int ans = smallestNonConstructibleValue(nums);
		
		System.out.println(ans);
	}

}
