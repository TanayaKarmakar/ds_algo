package com.app.bitmanipulation.problems;

public class SetNthBit {
	public static void isNthBitSet(int num, int n) {
		int val = 1 << n;
		int res = num & val;
		if (res > 0) {
			System.out.println(n + "th bit is set");
		} else {
			System.out.println("not set");
		}
	}

	public static void main(String[] args) {
		int num = 5;
		int n = 2;

		isNthBitSet(num, n);
	}

}
