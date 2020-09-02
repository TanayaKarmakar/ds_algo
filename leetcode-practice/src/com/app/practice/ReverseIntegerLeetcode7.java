package com.app.practice;

public class ReverseIntegerLeetcode7 {
	private static int reverse(int x) {
		long sum = 0;
		int temp = Math.abs(x);
		boolean isNeg = false;
		if(x < 0) {
			isNeg = true;
		}
		while(temp != 0) {
			sum = sum * 10 + (temp % 10);
			temp = temp / 10;
		}
		
		if(sum >= Integer.MAX_VALUE || sum <= Integer.MIN_VALUE)
			return 0;
		if(isNeg) {
			return -(int)sum;
		}
		return (int)sum;
	}

	public static void main(String[] args) {
		int x = -123;
		
		System.out.println(reverse(x));

	}

}
