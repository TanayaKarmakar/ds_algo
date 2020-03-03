package com.app.recursion.problems;

public class LastIndex {
	private static int lastIndex(int[] input, int x, int startIndx) {
		if (startIndx == -1)
			return -1;
		if (input[startIndx] == x)
			return startIndx;
		return lastIndex(input, x, startIndx - 1);
	}

	public static int lastIndex(int[] input, int x) {
		return lastIndex(input, x, input.length - 1);
	}

	public static void main(String[] args) {
		int[] arr = { 9, 8, 10, 8 };
		
		System.out.println(lastIndex(arr, 8));

	}

}
