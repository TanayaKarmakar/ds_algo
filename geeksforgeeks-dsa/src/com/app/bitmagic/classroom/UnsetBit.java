package com.app.bitmagic.classroom;

public class UnsetBit {
	private static void unsetBit(int num, int n) {
		int leftShiftToNVal = (1 << n);
		leftShiftToNVal = ~(leftShiftToNVal);
		
		System.out.println("After unsetting " + n + "th bit - " + (num & leftShiftToNVal));
	}

	public static void main(String[] args) {
		int num = 15;
		int n = 2;
		unsetBit(num, n);
	}

}
