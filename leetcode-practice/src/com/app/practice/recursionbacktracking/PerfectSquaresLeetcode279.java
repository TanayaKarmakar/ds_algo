package com.app.practice.recursionbacktracking;

public class PerfectSquaresLeetcode279 {
	private static int perfectSquares(int n) {
		if(n <= 3)
			return n;
		int res = n;
		for(int i = 1; i <= n; i++) {
			int temp = i * i;
			if(temp > n)
				break;
			res = Integer.min(res, 1 + perfectSquares(n - temp));
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 12;
		
		System.out.println(perfectSquares(n));
	}
}
