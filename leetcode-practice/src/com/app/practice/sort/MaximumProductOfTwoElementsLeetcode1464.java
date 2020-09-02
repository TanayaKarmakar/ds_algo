package com.app.practice.sort;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumProductOfTwoElementsLeetcode1464 {
	private static int maxProduct(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		
		return (nums[n - 1] - 1) * (nums[n - 2] - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int maxProduct = maxProduct(nums);
		
		System.out.println(maxProduct);
		
		scanner.close();

	}

}
