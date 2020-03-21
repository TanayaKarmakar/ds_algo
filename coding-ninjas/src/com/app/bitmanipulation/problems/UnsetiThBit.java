package com.app.bitmanipulation.problems;

public class UnsetiThBit {
	private static void unsetiThBit(int num, int i) {
		if(i <= 0)
			return;
		int val = 1 <<(i - 1);
		int res = num & ~val;
		System.out.println(res);
	}

	public static void main(String[] args) {
		unsetiThBit(7, 2);
		unsetiThBit(12, 1);

	}

}
