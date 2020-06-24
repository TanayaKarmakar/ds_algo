package com.app.questions.binarysearch;

public class DivideIntegersLeetcode29 {
	private static int divide(int dividend, int divisor) {
		if(dividend == 0)
			return 0;
		boolean isNeg = false;
		if(dividend < 0 || divisor < 0)
			isNeg = true;
		if(dividend < 0 && divisor < 0)
			isNeg = false;
		long aDividend = (long)Math.abs(dividend);
		long aDivisor = (long)Math.abs(divisor);
		long start = 1;
		long end = aDividend;
		long finalAns = 0;
		while(start <= end) {
			long mid = start + (end - start) / 2;
			if(mid * aDivisor == aDividend) {
				if(isNeg) {
					mid = -mid;
				}
				if(mid > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				else if(mid < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
				else
					return (int)mid;
			}
			else if(mid * aDivisor > aDividend) {
				end = mid - 1;
			} else {
				finalAns = mid;
				start = mid + 1;
			}
		}
		if(isNeg) {
			finalAns = -finalAns;
		}
		if(finalAns > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else if(finalAns < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		else
			return (int)finalAns;
	}

	public static void main(String[] args) {
//		int dividend = 10;
//		int divisor = 3;
//		
//		int ans = divide(dividend, divisor);
//		
//		System.out.println(ans);

		int dividend = Integer.MIN_VALUE;
		int divisor = -1;
		
		int ans = divide(dividend, divisor);
		
		System.out.println(ans);
	}

}
