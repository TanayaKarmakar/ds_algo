package com.app.recursion.classroom;

public class PrintNumbersWithoutUsingLoop {
	
	private static void printNumAsc(int n) {
		if(n < 1) {
			System.out.println();
			return;
		}
		printNumAsc(n - 1);
		System.out.print(n + "\t");
	}
	
	private static void printNum(int n) {
		if(n < 1) {
			System.out.println();
			return;
		}
		System.out.print(n + "\t");
		printNum(n - 1);
	}

	public static void main(String[] args) {
		int n = 5;
		printNum(n);
		printNumAsc(n);

	}

}
