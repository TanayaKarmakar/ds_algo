package com.app.dp1.problems;

import java.util.Arrays;
import java.util.Scanner;

public class AngryChildren {
	private static long[] calculateUnfairness(long[] bags, int start, int end) {
		long unfairness = 0;
		long sum = 0;
		int j = 0;
		for (int i = start; i < end; i++) {
			sum += bags[i];
			unfairness += j * bags[i];
			unfairness -= (end - start - 1 - j) * bags[i];
			j++;
		}
		return new long[] { unfairness, sum - bags[start] };
	}
	
	private static long[] calculateUnfairness(long lastUnfairness, long lastSum, long in, long out, long second, long k) {
        long unfairness = lastUnfairness + (k - 1) * out;
        unfairness -= lastSum;
        unfairness += ((k - 1) * in) - lastSum;
        lastSum -= second;
        lastSum += in;
        return new long[]{unfairness, lastSum};
    }

	private static long getMinUnfairness(long[] nums, int n, int k) {
		long results[] = calculateUnfairness(nums, 0, k);
		long lastUnfairness = results[0];
		long lastSum = results[1];
		long lowestUnfairness = Long.MAX_VALUE;

		for (int i = k; i < nums.length; i++) {
			results = calculateUnfairness(lastUnfairness, lastSum, nums[i], nums[i - k], nums[i - k + 1], k);
			lastUnfairness = results[0];
			lastSum = results[1];
			if (lastUnfairness < lowestUnfairness) {
				lowestUnfairness = lastUnfairness;
			}
		}

		return lowestUnfairness;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		long[] nums = new long[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextLong();
		}
		Arrays.sort(nums);
		
		long lowestUnfairness = getMinUnfairness(nums, n, k);
		
		System.out.println(lowestUnfairness);
		scanner.close();
	}

}
