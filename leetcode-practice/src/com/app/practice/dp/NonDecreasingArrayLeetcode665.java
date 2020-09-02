package com.app.practice.dp;

import java.util.Scanner;

public class NonDecreasingArrayLeetcode665 {
	private static boolean checkPossibility(int[] nums) {
		int n = nums.length;
		
		int maxLen = 1;
		int[] lis = new int[n];
		
		lis[0] = 1;
		for(int i = 1; i < n; i++) {
			lis[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					lis[i] = Integer.max(lis[i], lis[j] + 1);
				}
				maxLen = Integer.max(maxLen, lis[i]);
			}
		}
		
		return (n - maxLen) <= 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		boolean ans = checkPossibility(nums);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
