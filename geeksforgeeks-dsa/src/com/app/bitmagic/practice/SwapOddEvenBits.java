package com.app.bitmagic.practice;

public class SwapOddEvenBits {
	private static int swapOddEven(int num) {
		int setEvenBits = num & (0xAAAAAAAA);
		int setOddBits = num & (0x55555555);
		return (setEvenBits >> 1) | (setOddBits << 1);
	}

	public static void main(String[] args) {
		System.out.println("Swapping odd and even bits - " + swapOddEven(23));

	}

}
