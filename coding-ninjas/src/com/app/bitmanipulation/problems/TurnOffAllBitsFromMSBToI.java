package com.app.bitmanipulation.problems;

public class TurnOffAllBitsFromMSBToI {
	private static int turnOffBits(int num, int i) {
		int mask = ((1 << i) - 1);
		return (num & mask);
	}

	public static void main(String[] args) {
		System.out.println(turnOffBits(15, 2));

	}

}
