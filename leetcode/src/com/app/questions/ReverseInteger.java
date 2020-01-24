package com.app.questions;

public class ReverseInteger {
//	private static int reverseEff(int data) {
//		int tmp = Math.abs(data);
//		int rev = 0;
//		
//		while(tmp > 0) {
//			int r = tmp % 10;
//			
//		}
//	}
	
	private static int reverse(int data) {
		long res = 0;
		int tmp = Math.abs(data);
		
		while(tmp > 0) {
			int r = tmp % 10;
			res = res * 10 + r;
			tmp = tmp / 10;
		}
		
		if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
			return 0;
		else if(data < 0)
			return -(int)res;
		else
			return (int)res;
	}

	public static void main(String[] args) {
		int a = 123;
		
		System.out.println(reverse(a));
		
		a = -123;
		
		System.out.println(reverse(a));
		
		//System.out.println(Integer.MAX_VALUE);
		
		a = 2147483646;
		
		System.out.println(reverse(a));

	}

}
