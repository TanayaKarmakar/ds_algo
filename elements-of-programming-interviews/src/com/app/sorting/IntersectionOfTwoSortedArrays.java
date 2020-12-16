package com.app.sorting;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {
	private static int isPresent(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	// This method is useful when one array is much shorter than the other
	private static List<Integer> intersectionApproach1(int[] a, int[] b) {
		if (a.length > b.length) {
			int[] temp = a;
			a = b;
			b = temp;
		}

		int m = a.length;

		List<Integer> intersectionAB = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int indx = isPresent(b, a[i]);
			if (indx != -1 && (i == 0 || a[i - 1] != a[i])) {
				intersectionAB.add(a[i]);
			}
		}

		return intersectionAB;
	}

	private static List<Integer> intersectionApproach2(int[] a, int[] b) {
		List<Integer> intersectionAB = new ArrayList<>();

		int i = 0;
		int j = 0;

		while (i < a.length && j < b.length) {
			if (a[i] == b[j] && (i == 0 || a[i - 1] != a[i])) {
				intersectionAB.add(a[i]);
				i++;
				j++;
			} else if (a[i] < b[j])
				i++;
			else
				j++;

		}

		return intersectionAB;
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 3, 5, 5, 6, 7, 7, 8 };
		int[] b = { 1, 3, 5, 5, 9 };

		List<Integer> intersectionAB = intersectionApproach1(a, b);

		System.out.println(intersectionAB);

		a = new int[] { 2, 3, 3, 5, 5, 6, 7, 7, 8 };
		b = new int[] { 5, 5, 6, 8, 8, 9, 10 };
		
		intersectionAB = intersectionApproach2(a, b);

		System.out.println(intersectionAB);
	}

}
