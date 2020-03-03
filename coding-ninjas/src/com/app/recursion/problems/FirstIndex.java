package com.app.recursion.problems;

public class FirstIndex {
	private static int firstIndex(int[] input, int x, int startIndx) {
		if (startIndx == input.length)
			return -1;
		if (input[startIndx] == x)
			return startIndx;
		return firstIndex(input, x, startIndx + 1);
	}

	public static int firstIndex(int[] input, int x) {
		return firstIndex(input, x, 0);
	}

	public static void main(String[] args) {
		int[] arr = { 9, 8, 10, 8 };
		
		System.out.println(firstIndex(arr, 8));

	}

}
