package com.app.array;

import java.util.ArrayList;
import java.util.List;

public class IncrementNumberByOneSpaceEfficient {
	private static List<Integer> increment(List<Integer> nums) {
		int n = nums.size() - 1;
		nums.set(n, nums.get(n) + 1);

		for (int i = n; i > 0 && nums.get(i) == 10; i--) {
			nums.set(i, 0);
			nums.set(i - 1, nums.get(i - 1) + 1);
		}

		if (nums.get(0) == 10) {
			nums.set(0, 1);
			nums.add(0);
		}

		return nums;
	}

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(9);

		List<Integer> result = increment(nums);

		System.out.println(result);

		nums = new ArrayList<>();
		nums.add(9);
		nums.add(9);
		nums.add(9);

		result = increment(nums);

		System.out.println(result);
	}

}
