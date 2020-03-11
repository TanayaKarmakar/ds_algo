package com.app.languagetools1.problems;

import java.util.Arrays;

public class PairSum {
	private static void pairSum(int[] input, int size) {
		Arrays.sort(input);
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (input[i] + input[j] == 0) {
					System.out.println(input[i] + " " + input[j]);
				}
			}
		}
//		int start = 0;
//		int end = input.length - 1;
//		while (start < end) {
//			int sum = input[start] + input[end];
//			if (sum == 0) {
//				System.out.println(input[start] + " " + input[end]);
//				start++;
//				end--;
//			} else if (sum < 0) {
//				start++;
//			} else {
//				end--;
//			}
//		}
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, -2, 2, 3 };
		pairSum(nums, nums.length);

	}

}
