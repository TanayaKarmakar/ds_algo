package com.app.assignment1.problems;

import java.util.Scanner;

public class SortTheSkills {
	private static boolean isPossible(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (i + 1 < n) {
				if (nums[i + 1] == nums[i] - 1) {
					int tmp = nums[i + 1];
					nums[i + 1] = nums[i];
					nums[i] = tmp;
				}
			}
		}
		
		for(int i = 1; i < n; i++) {
			if(nums[i] < nums[i - 1])
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases > 0) {
			int nDim = scanner.nextInt();
			int[] nums = new int[nDim];
			for(int i = 0; i < nDim; i++) {
				nums[i] = scanner.nextInt();
			}
			boolean isPossible = isPossible(nums);
			if(isPossible) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			
			nTestCases--;
		}
		
		scanner.close();

	}

}
