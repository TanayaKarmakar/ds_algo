package com.app.searchsort.problems;

import java.util.Scanner;

public class TajmahalEntry {
	
	private static boolean isConfigurationPossible(int[] nums, int mid) {
		int n = nums.length;
		for(int i = 0; i < n; i++) {
			int curr = (i + mid * n);
			//System.out.println(curr);
			if(curr >= nums[i]) {
				return true;
			}		
		}
		return false;
	}
	
	private static int getWindow(int[] nums, int n) {
		int start = 0;
		int end = (int)Math.pow(10, 9);
		int midVal = 0;
		
		while(start < end) {
			int mid = start + (end - start)/2;
			if(isConfigurationPossible(nums, mid)) {
				midVal = Integer.min(midVal, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		int finalAns = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			int curr = (i + midVal * n);
			if(curr >= nums[i]) {
				finalAns = Integer.min(finalAns, curr);
			}
			
		}
        if(finalAns == Integer.MAX_VALUE) {
            finalAns = 0;
        }
		return finalAns + 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = scanner.nextInt();

		int[] nums = new int[nDim];
		for (int i = 0; i < nDim; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int window = getWindow(nums, nDim);
		
		System.out.println(window + 1);
		scanner.close();
	}

}
