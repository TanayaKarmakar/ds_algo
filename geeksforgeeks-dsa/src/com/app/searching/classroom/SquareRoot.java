package com.app.searching.classroom;

public class SquareRoot {
//	private static double findSquareRootSmallerPrecision(double number) {
//		double diff = 0.00005;
//		double start = 0;
//		double end = number;
//		double prevMid = 0;
//		double mid = 0;
//
//		while (start <= end) {
//			mid = (start + end) / 2;
//			if (Math.floor(mid * mid) == number)
//				return mid;
//			else if (mid * mid != number && Math.floor(Math.abs(prevMid - mid)) > diff) {
//				if(mid * mid > number) {
//					end = mid;
//				} else {
//					start = mid;
//				}
//				prevMid = mid;
//			}
//		}
//		return prevMid;
//	}

	private static int findSquareRoot(int number) {
		int start = 1;
		int end = number;
		int ans = 0;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid * mid == number)
				return mid;
			else if (mid * mid > number) {
				end = mid - 1;
			} else {
				start = mid + 1;
				ans = mid;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			System.out.println("Square root of " + i + " is " + findSquareRoot(i));
		}
		
		//for (int i = 1; i <= 100; i++) {
			//System.out.println("Square root of 9 is " + findSquareRootSmallerPrecision(9));
		//}
	}

}
