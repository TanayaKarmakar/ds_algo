package com.app.bitmagic.classroom;

public class PowerOf2 {
	private static boolean isPowerOf2(int num) {
		return num != 0 && (num & (num - 1)) == 0;
	}

	public static void main(String[] args) {
		System.out.println("Is power of two - " + isPowerOf2(4));
		System.out.println("Is power of two - " + isPowerOf2(7));
		System.out.println("Is power of two - " + isPowerOf2(0));
	}

}
