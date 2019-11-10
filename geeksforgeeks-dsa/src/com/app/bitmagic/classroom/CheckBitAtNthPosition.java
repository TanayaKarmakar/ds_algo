package com.app.bitmagic.classroom;

//Checking if bit at nth position is set or unset:
public class CheckBitAtNthPosition {
	private static void checkBitAtNthPosition(int num, int n) {
		int leftShiftToNThPos = (1 << (n - 1));
		if ((num & leftShiftToNThPos) == 0) {
			System.out.println("Bit is unset");
		} else {
			System.out.println("Bit is set");
		}
	}

	public static void main(String[] args) {
		int num = 12;
		int n = 2;
		
		checkBitAtNthPosition(num, n);
	}

}
