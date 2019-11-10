package com.app.bitmagic.classroom;

public class Logarithm {
	private static int logBase2(int number) {
		int res = 0;
		while((number >>= 1) != 0) {
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		int num = 12;
		System.out.println(logBase2(num));
	}

}
