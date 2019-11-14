package com.app.array.classroom;

public class MaximumOccurredIntegerInNRanges {
	private static int maxOccurredInteger(int[] left, int[] right) {
		int n = left.length;
		int MAX = 1000;
		int end = Integer.MIN_VALUE;

		int[] prefixArray = new int[MAX];

		for (int i = 0; i < n; i++) {
			prefixArray[left[i]]++;
			prefixArray[right[i] + 1]--;
			if (right[i] + 1 > end) {
				end = right[i] + 1;
			}
		}

		int maxFreq = Integer.MIN_VALUE;
		for (int i = 1; i < end; i++) {
			prefixArray[i] += prefixArray[i - 1];
			if (prefixArray[i] > maxFreq) {
				maxFreq = prefixArray[i];
			}
		}

		return maxFreq;
	}

	public static void main(String[] args) {
		int[] left = { 1, 2, 3 };
		int[] right = { 3, 5, 7 };
		System.out.println("Max occurred integer - " + maxOccurredInteger(left, right));
	}

}
