package com.app.questions;

public class PerfectSquaresRec {
	private static int numPerfectSquares(int n) {
		if (n <= 3)
			return n;

		int res = n;
		for (int x = 1; x <= n; x++) {
			int temp = x * x;
			if (temp > n)
				break;
			res = Math.min(res, 1 + numPerfectSquares(n - temp));
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(numPerfectSquares(12));
		
		System.out.println(numPerfectSquares(56));

	}

}
