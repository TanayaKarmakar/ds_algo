package com.app.practice.binarysearch;

import java.util.Scanner;

public class SearchInASortedAndRotatedArrayIILeetcode81 {
	private static boolean search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(nums[mid] == target)
				return true;
			else if(nums[mid] < nums[end]) {
				if(target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid;
			} else if(nums[mid] > nums[end]) {
				if(target >= nums[start] && target < nums[mid])
					end = mid;
				else
					start = mid + 1;
			} else {
				end--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int target = scanner.nextInt();
		
		boolean ans = search(nums, target);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
