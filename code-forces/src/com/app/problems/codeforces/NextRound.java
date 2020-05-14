package com.app.problems.codeforces;

import java.util.Scanner;

public class NextRound {
	private static int getCount(int[] nums, int k, int n) {
		int el = nums[k - 1];
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(nums[i] >= el && nums[i] > 0) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}

		int count = getCount(nums, k, n);
		
		System.out.println(count);
		scanner.close();
	}

}
