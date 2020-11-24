package com.app.practice.array;

import java.util.Arrays;

public class HIndexLeetcode274 {
	private static int hIndex(int[] citations) {
		Arrays.sort(citations);
		int n = citations.length;

		int i;
		for (i = 1; i <= n; i++) {
			if (citations[n - i] < i)
				break;
		}

		return (i - 1);
	}

	public static void main(String[] args) {
		int[] nums = { 3, 0, 6, 1, 5 };
		
		int ans = hIndex(nums);
		
		System.out.println(ans);

	}

}
