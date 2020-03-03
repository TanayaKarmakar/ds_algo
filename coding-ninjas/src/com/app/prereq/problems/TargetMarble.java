package com.app.prereq.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetMarble {
	private static boolean isArrangementPossible(int[] nums, int target, List<Integer> res) {
		int n = nums.length;
		int start = 0;
		int end = n - 1;
		int sum = 0;
		while(start <= end) {
			if(nums[start] > target) {
				if(sum > 0) {
					sum = 0;
					res.clear();
				}
				start++;
			} else if(nums[start] == target) {
				res.clear();
				res.add(nums[start]);
				return true;
			} else {
				sum += nums[start];
				res.add(nums[start]);
				start++;
				if(sum == target)
					return true;
				if(sum > target) {
					sum = 0;
					res.clear();
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int nDim = Integer.parseInt(input.split("\\s+")[0]);
		int target = Integer.parseInt(input.split("\\s+")[1]);
		
		int[] nums = new int[nDim];
		String strInput = scanner.nextLine();
		
		int indx = 0;
		for(String el: strInput.split("\\s+")) {
			nums[indx++] = Integer.parseInt(el);
		}
		
		List<Integer> res = new ArrayList<>();
		boolean isPossible = isArrangementPossible(nums, target, res);
		System.out.println(isPossible);
		if(isPossible) {
			for(Integer el: res) {
				System.out.print(el + " ");
			}
			System.out.println();
		}
		scanner.close();

	}

}
