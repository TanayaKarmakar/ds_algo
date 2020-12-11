package com.app.practice.slidingwindow;

public class MaximumPointsObtainedFromCardsLeetcode1423 {
	private static int maxScore(int[] cardPoints, int k) {
		int n = cardPoints.length;
		int totalSum = 0;

		for (int i = 0; i < n; i++) {
			totalSum += cardPoints[i];
		}

		if (k == n)
			return totalSum;

		int maxPoint = 0;
		int l = 0;
		int r = 0;
		int windowSize = (n - k);
		int sum = 0;
		for (r = 0; r < windowSize; r++) {
			sum += cardPoints[r];
		}

		while (r < n) {
			maxPoint = Integer.max(maxPoint, totalSum - sum);
			sum = sum - cardPoints[l] + cardPoints[r];
			l++;
			r++;
		}
		maxPoint = Integer.max(maxPoint, totalSum - sum);

		return maxPoint;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 1 };
		int k = 3;
		
		int ans = maxScore(nums, k);
		
		System.out.println(ans);

	}

}
