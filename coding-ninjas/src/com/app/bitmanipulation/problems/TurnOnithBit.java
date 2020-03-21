package com.app.bitmanipulation.problems;

public class TurnOnithBit {
	private static void turnOniThBit(int num, int i) {
		int res = num | (1 << i);
		
		System.out.println(res);
	}

	public static void main(String[] args) {
		turnOniThBit(4, 1);

	}

}
