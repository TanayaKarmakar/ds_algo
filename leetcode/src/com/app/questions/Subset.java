package com.app.questions;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Subset {
	private static List<List<Integer>> generateSubsets(int[] nums, List<List<Integer>> res, int startIndx) {
		if (startIndx == nums.length) {
			List<Integer> item = new ArrayList<>();
			res.add(item);
			return res;
		}
		res = generateSubsets(nums, res, startIndx + 1);
		int num = nums[startIndx];
		List<List<Integer>> smallOutput = new ArrayList<>();
		smallOutput.addAll(res);
		for (List<Integer> el : res) {
			List<Integer> curr = new ArrayList<>();
			curr.add(num);
			curr.addAll(el);
			smallOutput.add(curr);
		}
		return smallOutput;
	}

	private static List<List<Integer>> generateSubsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res = generateSubsets(nums, res, 0);
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = generateSubsets(nums);
		
		for(List<Integer> el: res) {
			System.out.println(el);
		}
	}

}
