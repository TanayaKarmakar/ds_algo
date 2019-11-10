package com.app.recursion.practice;

public class DigitalRoot {
	private static int digitalRootAlternate(int num) {
		if(num < 10)
			return num;
		return digitalRootAlternate(num % 10 + num / 10);
	}
	private static int digitalRoot(int num) {
		while(num >= 10) {
			num = num % 10 + digitalRoot(num / 10);
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(digitalRoot(191));
		System.out.println(digitalRoot(99999));
		System.out.println(digitalRootAlternate(191));
		System.out.println(digitalRootAlternate(99999));
	}

}
