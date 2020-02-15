package com.app.questions;

// Remove Duplicates from Sorted Array II -- leetcode
public class RemoveDuplicates1 {
	private static int removeDuplicates(int[] nums) {
		int n = nums.length;

		int i = 0;
		int j = 1;
		int len = nums.length;
		while (i < len && j < len) {
			while (j < len && nums[i] == nums[j])
				j++;
			if ((j - i) <= 2) {
				i = j;
				j = i + 1;
			} else {
				int startPos = i + 2;
				// len = len - (j - startPos);
				i = startPos;
				for (int k = j; k < len; k++) {
					nums[startPos++] = nums[k];
				}
				len = startPos;
				while (startPos < len) {
					nums[startPos++] = -1;
				}
				j = i + 1;
			}
		}

		return len;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 2, 2, 3 };
		int len = removeDuplicates(arr);
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\nLength - " + len);

		arr = new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		len = removeDuplicates(arr);
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\nLength - " + len);

		arr = new int[] { 1, 1, 2, 2, 2, 3, 3, 3, 3 };
		len = removeDuplicates(arr);
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\nLength - " + len);
	}

}
