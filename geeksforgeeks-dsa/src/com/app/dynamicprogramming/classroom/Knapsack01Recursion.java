package com.app.dynamicprogramming.classroom;

public class Knapsack01Recursion {
	private static int knapSack(int[] v, int[] w, int wt, int n) {
		if (n == 0 || wt == 0)
			return 0;
		if (w[n - 1] > wt) {
			return knapSack(v, w, wt, n - 1);
		} else {
			int notIncluded = knapSack(v, w, wt, n - 1);
			int included = v[n - 1] + knapSack(v, w, wt - w[n - 1], n - 1);
			return Integer.max(notIncluded, included);
		}
	}

	public static void main(String[] args) {
		int[] values = { 10, 40, 30, 50 };
		int[] weights = { 5, 4, 6, 3 };
		int targetWeight = 10;
		int len = values.length;
		
		System.out.println("Maximum value - " + 
				knapSack(values, weights, targetWeight, len));

	}

}
