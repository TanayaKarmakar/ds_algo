package com.app.questions;

import java.util.Arrays;

public class MergeSortedArrayEfficient {
	private static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		while(i >=0 && j >= 0) {
			if(nums1[i] < nums2[j]) {
				nums1[i + j + 1] = nums2[j--];
			} else {
				nums1[i + j + 1] = nums1[i--];
			}
		}
		
		while(j >= 0) {
			nums1[i + j + 1] = nums2[j--];
		}
		
		System.out.println(Arrays.toString(nums1));
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 5, 7, 8, 10, 12, 0, 0, 0, 0 };
		int[] nums2 = { 2, 3, 4 };

		mergeSortedArray(nums1, 6, nums2, 3);

	}

}
