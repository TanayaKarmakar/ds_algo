package com.app.sorting;

import java.util.Arrays;

public class HIndex {
	private static int hIndex(int[] citations) {
		Arrays.sort(citations);

		int n = citations.length;
		for (int i = 0; i < n; i++) {
			if (citations[i] >= (n - i))
				return (n - i);
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] citations = { 1, 4, 1, 4, 2, 1, 3, 5, 6 };
		
		int ans = hIndex(citations);
		
		System.out.println(ans);
	}

}
