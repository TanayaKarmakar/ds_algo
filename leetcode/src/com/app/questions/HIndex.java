package com.app.questions;

import java.util.Arrays;

public class HIndex {
	private static int hIndex(int[] citations) {
		Arrays.sort(citations);

		int n = citations.length;

		int res = 0;

		for (int i = 0; i < n; i++) {
			if (citations[i] >= (n - i)) {
				return res = n - i;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 0, 6, 1, 5 };
		
		System.out.println("HIndex - " + hIndex(arr));

	}

}
