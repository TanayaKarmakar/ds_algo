package com.app.problems.hackerearth.binarysearch;

import java.util.Scanner;

public class BishuAndSoldiers {
	private static int findIndx(int[] nums, int strength) {
		int n = nums.length;
		if (strength < nums[0])
			return 0;
		else if (strength > nums[n - 1])
			return (n - 1);
		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + end) >> 1;
			if (nums[mid] == strength) {
				return mid;
			} else if (nums[mid] > strength)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	private static int[] getValue(int[] nums, int strength) {
		int indx = findIndx(nums, strength);

		int cnt = 0;
		int totalSum = 0;

		if (indx == 0 || indx == -1) {
			return new int[] { cnt, totalSum };
		} else if (indx == nums.length - 1) {
			for (int num : nums) {
				totalSum += num;
			}
			cnt = nums.length;
			return new int[] { cnt, totalSum };
		} else {
			cnt = indx + 1;
			for(int i = indx; i >= 0; i--) {
				totalSum += nums[i];
			}
			return new int[] {cnt, totalSum};
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}

		int query = scanner.nextInt();
		while (query-- > 0) {
			int strength = scanner.nextInt();
			int[] value = getValue(nums, strength);
			
			System.out.println(value[0] + " " + value[1]);
		}
		scanner.close();
	}
}
