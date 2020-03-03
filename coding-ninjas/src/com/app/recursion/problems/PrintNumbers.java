package com.app.recursion.problems;

public class PrintNumbers {
	private static void print(int n) {
		if(n == 0)
			return;
		print(n - 1);
		System.out.print(n + " ");
	}

	public static void main(String[] args) {
		int n = 5;
		print(n);

	}

}
