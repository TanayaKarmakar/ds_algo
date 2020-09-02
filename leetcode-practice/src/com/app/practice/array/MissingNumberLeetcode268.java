package com.app.practice.array;

import java.util.Scanner;

public class MissingNumberLeetcode268 {
	private static int missingNumber(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for(int i = 0; i <= n; i++)
			sum += i;
		
		for(int i = 0; i < n; i++) {
			sum -= nums[i];
		}
		
		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int ans = missingNumber(nums);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
