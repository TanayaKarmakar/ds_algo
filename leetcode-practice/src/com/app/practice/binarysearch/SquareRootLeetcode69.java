package com.app.practice.binarysearch;

public class SquareRootLeetcode69 {
	private static int mySqrt(int x) {
		if(x <= 1)
			return x;
		long start = 1;
		long end = x;
		long ans = 0;
		while(start <= end) {
			long mid = (start + end) / 2;
			if((mid * mid) == x)
				return (int)mid;
			else if((mid * mid) > x) {
				end = mid - 1;
			} else {
				ans = mid;
				start = mid + 1;
			}
		}
		
		return (int)ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
