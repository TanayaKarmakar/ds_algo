package com.app.adhoc.problems;

import java.util.Scanner;

//need to understand again
public class InterestingSequences {
	private static int getMinCost(int[] nums, int k, int l, int n) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			min = Integer.min(min, nums[i]);
			max = Integer.max(max, nums[i]);
		}
		
		int inc = 0;
		int dec = 0;
		
		int cost = Integer.MAX_VALUE;
		
		for(int i = min; i <= max; i++) {
			inc = 0;
			dec = 0;
			for(int j = 0; j < n; j++) {
				if(nums[j] > i) {
					inc += (nums[j] - i);
				}
				else if(nums[j] < i) {
					dec += (i - nums[j]);
				}
			}
			int currentCost = dec * l + (inc - dec) * k;
			//System.out.println("CurrentCost - " + currentCost);
			if(currentCost >= 0) {
				cost = Integer.min(cost, currentCost);
			}
			
		}
		
		return cost;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int l = scanner.nextInt();
		
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int cost = getMinCost(nums, k, l, n);
		System.out.println(cost);
		
		scanner.close();

	}

}
