package com.app.practice.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetsIILeetcode90 {
	private static void subsetsWithDup(int[] nums, int start, List<Integer> item, List<List<Integer>> res) {
		res.add(new ArrayList<>(item));
		
		for(int i = start; i < nums.length; i++) {
			if(i > start && nums[i - 1] == nums[i])
				continue;
			item.add(nums[i]);
			subsetsWithDup(nums, i + 1, item, res);
			item.remove(item.size() - 1);
		}
	}
	
	private static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<Integer> items = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		
		subsetsWithDup(nums, 0, items, res);
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		List<List<Integer>> res = subsetsWithDup(nums);
		
		System.out.println(res);
		
		scanner.close();

	}

}
