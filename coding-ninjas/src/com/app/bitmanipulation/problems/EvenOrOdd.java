package com.app.bitmanipulation.problems;

public class EvenOrOdd {
	private static void evenOrOdd(int n) {
		int res = n & 1;
		if(res == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
	}

	public static void main(String[] args) {
		evenOrOdd(5);
		evenOrOdd(8);

	}

}
