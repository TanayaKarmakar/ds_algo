package com.app.practice.greedy;

import java.util.Scanner;

public class BestTimeToBuyAndSellStockIILeetcode122 {
	private static int maxProfit(int[] nums) {
		int n = nums.length;
		int maxProfit = 0;
		
		int i = 0;
		while(i < n) {
			while((i + 1) < n && nums[i + 1] < nums[i])
				i++;
			int start = i++;
			
			while((i + 1) < n && nums[i] < nums[i + 1])
				i++;
			int end = i++;
			
			if(start < n && end < n) {
				maxProfit += (nums[end] - nums[start]);
			}
		}
		
		return maxProfit;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int maxProfit = maxProfit(nums);
		
		System.out.println(maxProfit);
		
		scanner.close();

	}

}
