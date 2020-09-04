package com.app.practice.sort;

import java.util.Arrays;
import java.util.Comparator;

class NumberComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if (o1.length() == o2.length())
			return o2.compareTo(o1);
		StringBuilder sb1 = new StringBuilder(o1 + o2);
		StringBuilder sb2 = new StringBuilder(o2 + o1);
		return sb2.toString().compareTo(sb1.toString());
	}

}

public class LargestNumberLeetcode179 {
	private static String largestNumber(int[] nums) {
		int n = nums.length;
		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			arr[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(arr, new NumberComparator());

		StringBuilder sb = new StringBuilder();
		for (String el : arr) {
			sb.append(el);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 30, 34, 5, 9 };
		String ans = largestNumber(nums);

		System.out.println(ans);
	}

}
