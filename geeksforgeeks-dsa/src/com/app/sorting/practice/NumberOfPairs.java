package com.app.sorting.practice;

import java.util.Arrays;

public class NumberOfPairs {
	private static int findPairs(int[] x, int[] y) {
		int ans = 0;
		int m = x.length;
		int n = y.length;

		Arrays.sort(x);
		Arrays.sort(y);

		int i = 0;
		int j = 0;

		while (i < m && j < n) {
			int pow1 = (int) Math.pow(x[i], y[j]);
			int pow2 = (int) Math.pow(y[j], x[i]);

			if (pow1 > pow2) {
				ans++;
				j++;
			} else {
				i++;
			}
		}

		if (j == n) {
			j = 0;
			while (i < m && j < n) {
				int pow1 = (int) Math.pow(x[i], y[j]);
				int pow2 = (int) Math.pow(y[j], x[i]);

				if (pow1 > pow2) {
					ans++;
					j++;
				} else {
					i++;
				}
			}
		}

		if (i == m) {
			i = 0;
			while (j < n && i < m) {
				int pow1 = (int) Math.pow(x[i], y[j]);
				int pow2 = (int) Math.pow(y[j], x[i]);

				if (pow1 > pow2) {
					ans++;
					j++;
				} else {
					i++;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] x = { 2, 1, 6 };
		int[] y = { 1, 5 };

		System.out.println(findPairs(x,y));
	}

}
