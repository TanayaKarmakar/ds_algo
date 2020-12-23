package com.app.search;

public class SquareRoot {
	private static int squareRoot(int num) {
		int left = 0;
		int right = num;
		while(left <= right) {
			int mid = left + (right - left)/2;
			if(mid * mid > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return left - 1;
	}

	public static void main(String[] args) {
		int num = 21;
		
		int ans = squareRoot(num);
		
		System.out.println(ans);

	}

}
