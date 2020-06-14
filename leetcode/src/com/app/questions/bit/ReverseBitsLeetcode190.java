package com.app.questions.bit;

public class ReverseBitsLeetcode190 {
	private static int reverseBits(int n) {
		boolean neg = (n < 0) ? true: false;
		int reverseBits = 0;
		int lastBit = 0;
		for(int i = 31; i > 0; i--) {
			lastBit = n & 1;
			reverseBits = (reverseBits | lastBit);
			reverseBits = reverseBits << 1;
			n = n >> 1;
		}
		return neg ? (reverseBits + 1): reverseBits;
	}

	public static void main(String[] args) {
		int n = 3;
		
		System.out.println(reverseBits(n));

	}

}
