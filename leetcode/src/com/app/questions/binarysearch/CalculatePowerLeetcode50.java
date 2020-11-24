package com.app.questions.binarysearch;

public class CalculatePowerLeetcode50 {
	private static double myPowRec(double x, int n) {
		if (n == 0)
			return 1;
		if (n % 2 == 0)
			return myPowRec(x, n / 2) * myPowRec(x, n / 2);
		else
			return x * myPowRec(x, (n - 1) / 2) * myPowRec(x, (n - 1) / 2);
	}
	
	private static double myPow(double x, int n) {
		long b = n;
		if(b < 0) {
			x = 1 / x;
			b = Math.abs(b);
		}
		double res = 1;
		while(b != 0) {
			if((b & 1) == 1) {
				res = res * x;
			}
			
			x = x * x;
			b = b >> 1;
		}
		
		return res;
	}

	public static void main(String[] args) {
		double x = 2;
		int n = -2;

		double ans = myPow(x, n);
		System.out.println(ans);
	}

}
