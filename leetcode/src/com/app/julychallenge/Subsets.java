package com.app.julychallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsets {
	private static void getSubsets(int[] nums, int start, List<Integer> items, List<List<Integer>> res) {
		
	}
	
	private static List<List<Integer>> getSubsets(int[] nums) {
		List<Integer> item = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		
		getSubsets(nums, 0, item, res);
		
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}

		scanner.close();
	}

}
