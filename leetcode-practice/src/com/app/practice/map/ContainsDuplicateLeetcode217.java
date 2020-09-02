package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContainsDuplicateLeetcode217 {
	private static boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() >= 2)
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		boolean ans = containsDuplicate(nums);
		
		System.out.println(ans);

		scanner.close();
	}

}
