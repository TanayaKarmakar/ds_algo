package com.app.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSumLeetcode18 {
	private static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);

		Set<List<Integer>> result = new HashSet<>();

		for (int i = 0; i < nums.length - 2; i++) {
			int num1 = nums[i];
			for (int j = i + 1; j < nums.length - 1; j++) {
				int num2 = nums[j];
				int start = j + 1;
				int end = nums.length - 1;

				while (start < end) {
					int sum = num1 + num2 + nums[start] + nums[end];
					if (sum == target) {
						List<Integer> numbers = new ArrayList<>();
						numbers.add(num1);
						numbers.add(num2);
						numbers.add(nums[start]);
						numbers.add(nums[end]);
						result.add(numbers);
						start++;
						end--;
					} else if (sum > target) {
						end--;
					} else {
						start++;
					}
				}
			}
		}
		return new ArrayList<>(result);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		
		List<List<Integer>> result = fourSum(nums, target);
		
		System.out.println(result);

	}

}
