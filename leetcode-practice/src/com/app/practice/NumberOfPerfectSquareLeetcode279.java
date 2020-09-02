package com.app.practice;

public class NumberOfPerfectSquareLeetcode279 {
	private static int numSquares(int n) {
		if(n <= 3)
			return n;
		int res = n;
		for(int i = 1; i <= n; i++) {
			int temp = i * i;
			if(temp > n)
				break;
			res = Integer.min(res, 1 + numSquares(n - temp));
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 12;
		
		int res = numSquares(n);
		
		System.out.println(res);
		
		n = 13;
		
		res = numSquares(n);
		
		System.out.println(res);

	}

}
