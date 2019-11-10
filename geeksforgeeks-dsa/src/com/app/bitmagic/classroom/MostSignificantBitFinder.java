package com.app.bitmagic.classroom;

public class MostSignificantBitFinder {
	private static int findLog2(int num) {
		int res = 0;
		while ((num >>= 1) != 0) {
			res++;
		}
		return res;
	}

	private static int findMSB(int num) {
		return (int) Math.floor(Math.pow(2, findLog2(num)));
	}

	public static void main(String[] args) {
		int n = 18;
		System.out.println("MSB of " + n + " is " + findMSB(n));

	}

}
