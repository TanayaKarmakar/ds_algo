package com.app.bitmagic.practice;

public class PositionOfSetBit {
	private static int positionOfSetBit(int n) {
		if(n == 0)
			return 0;
		int res = 0;
		while((n & 1)!= 1) {
			n = n >> 1;
			++res;
		}
		return (res + 1);
	}

	public static void main(String[] args) {
		System.out.println("First Set bit - " + positionOfSetBit(18));
		System.out.println("First Set bit - " + positionOfSetBit(12));

	}

}
