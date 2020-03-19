package com.app.assignment1.problems;

import java.util.Scanner;

public class CollectingTheBalls {
	private static long count(long nBalls, long low, long high) {
		if (nBalls == 1)
			return nBalls;
		long minK = 0;
		while (low < high) {
			long mid = low + (high - low) / 2;
			long current = nBalls;
			long sum = 0;
			while (current > 0) {
				sum = sum + Long.min(current, mid);
				current = current - mid;
				current = current - current / 10;
			}
			if (2 * sum >= nBalls) {
				high = mid;
				minK = mid;
			} else {
				low = mid + 1;
			}
		}
		return minK;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		long n = scanner.nextLong();
		long minK = count(n, 1, n);

		System.out.println(minK);

		scanner.close();

	}
}
