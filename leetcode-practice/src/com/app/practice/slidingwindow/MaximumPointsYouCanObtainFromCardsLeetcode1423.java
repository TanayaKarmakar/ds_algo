package com.app.practice.slidingwindow;

public class MaximumPointsYouCanObtainFromCardsLeetcode1423 {
	private static int maxScore(int[] cardPoints, int k) {
		int totalSum = 0;
		for (int point : cardPoints) {
			totalSum += point;
		}

		int n = cardPoints.length;
		int windowSize = n - k;

		int maxPoint = Integer.MIN_VALUE;

		int currentWindowSum = 0;
		int r = 0;
		for (r = 0; r < windowSize; r++) {
			currentWindowSum += cardPoints[r];
		}

		int l = 0;
		while (r < n) {
			maxPoint = Integer.max(totalSum - currentWindowSum, maxPoint);
			currentWindowSum += cardPoints[r] - cardPoints[l];
			l++;
			r++;
		}

		return maxPoint;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 1 };
		int k = 3;
		
		int maxSum = maxScore(nums, k);
		
		System.out.println(maxSum);

	}

}
