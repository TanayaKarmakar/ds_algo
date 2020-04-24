package com.app.questions.practice;

public class MedianOfSortedArrayLeetcode4 {
	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length)
			return findMedianSortedArrays(nums2, nums1);
		int n1 = nums1.length;
		int n2 = nums2.length;

		int begin1 = 0;
		int end1 = n1;

		while (begin1 <= end1) {
			int i1 = (begin1 + end1) / 2;

			int i2 = (n1 + n2 + 1) / 2 - i1;

			int min1 = (i1 == n1) ? Integer.MAX_VALUE : nums1[i1];
			int max1 = (i1 == 0) ? Integer.MIN_VALUE : nums1[i1 - 1];
			int min2 = (i2 == n2) ? Integer.MAX_VALUE : nums2[i2];
			int max2 = (i2 == 0) ? Integer.MIN_VALUE : nums2[i2 - 1];

			if (max1 <= min2 && max2 <= min1) {
				if ((n1 + n2) % 2 == 0) {
					double num1 = Double.max(max1, max2);
					double num2 = Double.min(min1, min2);
					return (num1 + num2) / 2.0;
					
				} else
					return Integer.max(max1, max2);
			} else if (max1 > min2) {
				end1 = i1 - 1;
			} else {
				begin1 = i1 + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };
		
		double mid = findMedianSortedArrays(nums1, nums2);
		
		System.out.println(mid);
	}

}
