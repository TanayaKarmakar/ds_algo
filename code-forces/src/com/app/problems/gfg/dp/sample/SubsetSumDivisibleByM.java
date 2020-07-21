package com.app.problems.gfg.dp.sample;

import java.util.Scanner;

public class SubsetSumDivisibleByM {
	private static boolean recHelper(int[] nums, int m, int indx, int sum) {
		if((sum != 0 && sum % m == 0) || nums.length == 0)
			return true;
		if(indx >= nums.length)
			return false;
		int sum1 = sum;
		boolean option1 = recHelper(nums, m, indx + 1, sum1);
		boolean option2 = recHelper(nums, m, indx + 1, sum1 + nums[indx]);
		return option1 || option2;
	}
	
	private static boolean recursion(int[] nums, int m) {
		return recHelper(nums, m, 0, 0);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int m = scanner.nextInt();
		
		boolean ans = recursion(nums, m);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
