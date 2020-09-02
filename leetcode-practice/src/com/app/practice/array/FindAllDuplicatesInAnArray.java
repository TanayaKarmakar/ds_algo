package com.app.practice.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllDuplicatesInAnArray {
	private static List<Integer> findDuplicates(int[] nums) {
		if (nums.length <= 1)
			return new ArrayList<>();

		int n = nums.length;
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int k = Math.abs(nums[i]);
			if (nums[k - 1] > 0) {
				nums[k - 1] = -nums[k - 1];
			} else {
				res.add(k);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		List<Integer> res = findDuplicates(nums);
		
		System.out.println(res);
		
		scanner.close();
	}

}
