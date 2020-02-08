package com.app.questions;

public class PowerOfTwo {
	private static boolean isPowerOfTwo(int num) {
		if(num <= 0)
			return false;
		return (num & (num - 1)) == 0;
	}

	public static void main(String[] args) {
		int num = 11;
		
		System.out.println(isPowerOfTwo(num));
		
		num = 16;
		
		System.out.println(isPowerOfTwo(num));

	}

}
