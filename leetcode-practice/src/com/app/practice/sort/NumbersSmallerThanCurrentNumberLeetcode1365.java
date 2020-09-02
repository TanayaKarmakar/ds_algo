package com.app.practice.sort;

import java.util.Arrays;
import java.util.Scanner;

public class NumbersSmallerThanCurrentNumberLeetcode1365 {
	private static int[] smallerNumbersThanCurrent(int[] nums) {
		int n = nums.length;
		
		int maxNum = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			maxNum = Integer.max(maxNum, nums[i]);
		}
		
		int[] count = new int[maxNum + 1];
		
		for(int i = 0; i < n; i++) {
			int k = nums[i];
			count[k]++;
		}
		
		for(int i = 1; i <= maxNum; i++) {
			count[i] += count[i - 1];
		}
		
		for(int i = 0; i < n; i++) {
			int k = nums[i];
			nums[i] = count[k - 1];
		}
		
		return nums;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		nums = smallerNumbersThanCurrent(nums);
		
		System.out.println(Arrays.toString(nums));
		
		scanner.close();
	}

}
