package com.app.practice.binarysearch;

import java.util.Scanner;

public class SearchInsertPositionLeetcode35 {
	private static int searchInsert(int[] nums, int target) {
		int start = 0;
		int n = nums.length;
		int end = n - 1;
		
		
		int indx = -1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(nums[mid] == target)
				return mid;
			else if(nums[mid] > target) {
				indx = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		if(indx == -1) {
			if(nums[end] < target) {
				indx = end + 1;
			}
		}
		
		return indx;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int target = scanner.nextInt();
		
		int indx = searchInsert(nums, target);
		
		System.out.println(indx);
		
		scanner.close();
	}

}
