package com.app.practice.bitmagic;

public class NumberOf1BitsLeetcode191 {
	private static int hammingWeight(int n) {
		int count = 0;
		while(n != 0) {
			count++;
			n = (n & (n - 1));
		}
		return count;
	}

	public static void main(String[] args) {
		int n = 8;
		
		System.out.println(hammingWeight(n));

	}

}
