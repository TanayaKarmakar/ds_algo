package com.app.practice.array;

import java.util.Scanner;

public class RemoveDuplicatesInSortedArrayLeetcode26 {
	private static int removeDuplicate(int[] nums) {
		int n = nums.length;
		int currentNumber = nums[0];
		int i = 0;
		int len = 1;
		
		while(i < n) {
			if(nums[i] == currentNumber) {
				i++;
			} else {
				currentNumber = nums[i];
				nums[len] = currentNumber;
				len++;
			}
		}
		
		return len;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int len = removeDuplicate(nums);
		
		for(int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();

		scanner.close();
	}

}
