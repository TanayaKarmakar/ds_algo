package com.app.bitmagic.classroom;

public class ToggleBit {
	private static void toggleNthBit(int num, int n) {
		int leftShiftToNVal = (1 << (n - 1));
		int res = num ^ leftShiftToNVal;
		System.out.println("Result - " + res);
	}

	public static void main(String[] args) {
		int num = 15, n = 2;
		toggleNthBit(num, n);
	}

}
