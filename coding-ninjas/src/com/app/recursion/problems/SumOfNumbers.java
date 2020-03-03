package com.app.recursion.problems;

public class SumOfNumbers {
	private static int sumRec(int[] input, int sum, int startIndx) {
		if (startIndx == input.length)
			return sum;
		return sumRec(input, sum + input[startIndx], startIndx + 1);
	}

	private static int sum(int[] input) {
		return sumRec(input, 0, 0);
	}

	public static void main(String[] args) {
		int[] arr = { 9, 8, 9 };
		System.out.println("Sum - " + sum(arr));

	}

}
