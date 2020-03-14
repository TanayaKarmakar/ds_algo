package com.app.bst.classroom;

import java.util.TreeSet;

public class CeiningOnLeftSideOfArray {

	public static void main(String[] args) {
		int[] nums = { 2, 8, 30, 15, 25, 12 };
		TreeSet<Integer> set = new TreeSet<>();

		set.add(nums[0]);
		System.out.print(-1 + " ");

		for (int i = 1; i < nums.length; i++) {
			if (set.ceiling(nums[i]) != null) {
				System.out.print(set.ceiling(nums[i]) + " ");
			} else {
				System.out.print(-1 + " ");
			}
			set.add(nums[i]);
		}

	}

}
