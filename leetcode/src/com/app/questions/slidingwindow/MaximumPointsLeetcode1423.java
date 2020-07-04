package com.app.questions.slidingwindow;

public class MaximumPointsLeetcode1423 {
	private static int maxScoreEfficient(int[] cardPoints, int k) {
		int totalSum = 0;
		for (int point : cardPoints) {
			totalSum += point;
		}

		if (k == cardPoints.length) {
			return totalSum;
		}
		
		int ans = Integer.MIN_VALUE;
		
		int sum = 0;
		int l = 0;
		int r = 0;
		int n = cardPoints.length;
		int windowSize = (n - k);
		for(r = 0; r < windowSize; r++) {
			sum += cardPoints[r];
		}
		
		while(r < n) {
			ans = Integer.max(ans, totalSum - sum);
			sum = sum - cardPoints[l] + cardPoints[r];
			l++;
			r++;
		}
		ans = Integer.max(ans, totalSum - sum);
		return ans;
	}
	
	private static int maxScore(int[] cardPoints, int k) {
		int totalSum = 0;
		for (int point : cardPoints) {
			totalSum += point;
		}

		if (k == cardPoints.length) {
			return totalSum;
		}
		int windowSize = cardPoints.length - k;
		int end = cardPoints.length;

		int start = 0;
		int ans = Integer.MIN_VALUE;
		while (start + windowSize <= end) {
			int sum = 0;
			for (int i = start; i < (start + windowSize); i++) {
				sum += cardPoints[i];
			}
			ans = Integer.max(ans, totalSum - sum);
			start++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 96, 90, 41, 82, 39, 74, 64, 50, 30 };

		int maxScore = maxScoreEfficient(nums, 8);

		System.out.println(maxScore);
		/*
		 * int[] nums = { 1, 2, 3, 4, 5, 6, 1 };
		 * 
		 * int maxScore = maxScore(nums, 3);
		 * 
		 * System.out.println(maxScore);
		 * 
		 * nums = new int[] { 2, 2, 2 };
		 * 
		 * maxScore = maxScore(nums, 2);
		 * 
		 * System.out.println(maxScore);
		 * 
		 * nums = new int[] { 9, 7, 7, 9, 7, 7, 9 };
		 * 
		 * maxScore = maxScore(nums, 7);
		 * 
		 * System.out.println(maxScore);
		 * 
		 * nums = new int[] { 1, 1000, 1 };
		 * 
		 * maxScore = maxScore(nums, 1);
		 * 
		 * System.out.println(maxScore);
		 * 
		 * nums = new int[] { 1, 79, 80, 1, 1, 1, 200, 1 };
		 * 
		 * maxScore = maxScore(nums, 3);
		 * 
		 * System.out.println(maxScore);
		 * 
		 * nums = new int[] { 11, 49, 100, 20, 86, 29, 72 };
		 * 
		 * maxScore = maxScore(nums, 4);
		 * 
		 * System.out.println(maxScore);
		 */
	}

}
