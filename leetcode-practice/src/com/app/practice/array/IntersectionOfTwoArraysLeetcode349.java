package com.app.practice.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArraysLeetcode349 {
	private static int[] intersection(int[] nums1, int[] nums2) {
		if(nums1.length == 0 || nums2.length == 0)
			return new int[] {};
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		Set<Integer> set = new HashSet<>();

		int m = nums1.length;
		int n = nums2.length;

		int i = 0;
		int j = 0;
		while (i < m && j < n) {
			if (nums1[i] < nums2[j])
				i++;
			else if (nums1[i] > nums2[j])
				j++;
			else {
				set.add(nums1[i]);
				i++;
				j++;
			}
		}

		int[] arr = new int[set.size()];
		i = 0;
		for (Integer el : set) {
			arr[i++] = el;
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		
		System.out.println(Arrays.toString(intersection(nums1, nums2)));

	}

}
