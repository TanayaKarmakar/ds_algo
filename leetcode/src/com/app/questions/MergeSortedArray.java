package com.app.questions;

import java.util.Arrays;

public class MergeSortedArray {
	private static void merge(int[] nums1, int m, int[] nums2, int n) {
		int tot = m + n;
		int[] res = new int[tot];

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < m && j < n) {
			if (nums1[i] <= nums2[j]) {
				res[k++] = nums1[i++];
			} else {
				res[k++] = nums2[j++];
			}
		}
		
		while(i < m) {
			res[k++] = nums1[i++];
		}
		
		while(j < n) {
			res[k++] = nums2[j++];
		}

		k = 0;
		i = 0;
		while (k < m + n) {
			nums1[i++] = res[k++];
		}
		
		System.out.println(Arrays.toString(nums1));
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 5, 7, 8, 10, 12, 0, 0, 0, 0 };
		int[] nums2 = { 2, 3, 4 };

		merge(nums1, 6, nums2, 3);

	}

}
