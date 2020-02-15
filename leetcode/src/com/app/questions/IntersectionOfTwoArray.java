package com.app.questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArray {
	private static int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length < nums2.length) {
			int[] tmp = nums1;
			nums1 = nums2;
			nums2 = tmp;
		}
		Set<Integer> numSet = new HashSet<>();
		for (int el : nums2) {
			numSet.add(el);
		}

		Set<Integer> res = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			if (numSet.contains(nums1[i])) {
				res.add(nums1[i]);
			}
		}

		int[] resArr = new int[res.size()];
		int count = 0;
		for (Integer el : res) {
			resArr[count++] = el;
		}
		return resArr;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };

		System.out.println(Arrays.toString(intersection(nums1, nums2)));

		nums1 = new int[] { 4, 9, 5 };
		nums2 = new int[] { 9, 4, 9, 8, 4 };
		
		System.out.println(Arrays.toString(intersection(nums1, nums2)));

	}

}
