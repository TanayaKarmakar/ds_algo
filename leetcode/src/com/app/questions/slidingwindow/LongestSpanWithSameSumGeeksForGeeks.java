package com.app.questions.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSpanWithSameSumGeeksForGeeks {
	private static int longestSpanWithSameSum(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = arr1[i] - arr2[i];

		Map<Integer, Integer> map = new HashMap<>();
		int preSum = 0;
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			preSum += arr[i];

			if (preSum == 0)
				maxLen = i + 1;

			if (map.containsKey(preSum))
				maxLen = Integer.max(maxLen, i - map.get(preSum));
			else
				map.put(preSum, i);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] nums1 = { 0, 1, 0, 0, 0, 0 };
		int[] nums2 = { 1, 0, 1, 0, 0, 1 };
		int maxLen = longestSpanWithSameSum(nums1, nums2);
		
		System.out.println(maxLen);
	}

}
