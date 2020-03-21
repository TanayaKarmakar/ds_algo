package com.app.bitmanipulation.problems;

public class TurnOffAllBitsFromLSBToI {
	private static int turnOffBits1(int num, int i) {
		int val = (255 << (i + 1));
		return (num & val);
	}
	
	private static int turnOffBits(int num, int i) {
		int mask = ~((1 << (i + 1)) - 1);
		return (mask & num);
	}

	public static void main(String[] args) {
		int num = 7;
		System.out.println(turnOffBits(num, 1));
		System.out.println(turnOffBits1(num, 1));

	}

}
