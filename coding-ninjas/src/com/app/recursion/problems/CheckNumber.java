package com.app.recursion.problems;

public class CheckNumber {
	private static boolean checkNumber(int[] input, int x, int startIndx) {
		if (startIndx == input.length)
			return false;
		if (input[startIndx] == x)
			return true;
		return checkNumber(input, x, ++startIndx);
	}

	private static boolean checkNumber(int[] input, int x) {
		return checkNumber(input, x, 0);
	}

	public static void main(String[] args) {
		int[] arr = { 9, 8, 10 };
		
		System.out.println(checkNumber(arr, 8));
		System.out.println(checkNumber(arr, 11));
	}

}
