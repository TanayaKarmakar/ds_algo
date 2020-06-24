package com.app.problems.gfg.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CombinationSumPart2 {
	private static void combinationSum(int[] nums, int target, Set<List<Integer>> res, 
			List<Integer> subsets, int indx) {
		if(target < 0)
			return;
		if(target == 0) {
			List<Integer> newSubset = new ArrayList<>();
			newSubset.addAll(subsets);
			res.add(newSubset);
			return;
		}
		
		for(int i = indx; i < nums.length; i++) {
			if(i > indx && nums[i - 1] == nums[i]) continue;
			subsets.add(nums[i]);
			combinationSum(nums, target - nums[i], res, subsets, i + 1);
			subsets.remove(subsets.size() - 1);	
		}
	}
	
	private static List<List<Integer>> combinationSum(int[] nums, int target) {
		Arrays.sort(nums);
		Set<List<Integer>> res = new HashSet<>();
		List<Integer> subsets = new ArrayList<>();
		combinationSum(nums, target, res, subsets, 0);
		return new ArrayList<>(res);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			
			int[] nums = new int[n];
			for(int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
			}
			int target = scanner.nextInt();
			
			List<List<Integer>> res = combinationSum(nums, target);
			if(res.isEmpty()) {
				System.out.println("Empty");
				continue;
			}
			
			for(List<Integer> items: res) {
				System.out.print("(");
				for(int i = 0; i < items.size(); i++) {
					if(i == items.size() - 1)
						System.out.print(items.get(i));
					else
						System.out.print(items.get(i) + " ");
				}
				System.out.print(")");
			}
			System.out.println();
		}
		scanner.close();
	}

}
