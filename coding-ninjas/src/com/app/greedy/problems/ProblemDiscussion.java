package com.app.greedy.problems;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemDiscussion {
	private static int minimizeDiff(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length;
		int diff = nums[n - 1] - nums[0];
		
		int small = nums[0] + k;
		int big = nums[n - 1] - k;
		if(small > big) {
			int tmp = small;
			small = big;
			big = tmp;
		}
		
		for(int i = 1; i <= n - 2; i++) {
			int add = nums[i] + k;
			int sub = nums[i] - k;
			if(sub >= small || add <= big) {
				continue;
			} else {
				if(add - small <= big - sub) {
					big = add;
				} else {
					small = sub;
				}
			}
		}
		
		return Integer.min(diff, big - small);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}

		int minDiff = minimizeDiff(nums, k);
		
		System.out.println(minDiff);
		scanner.close();
	}

}
