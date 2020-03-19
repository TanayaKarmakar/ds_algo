package com.app.assignment1.problems;

import java.util.Scanner;

public class PowerOfANumber {
	private static long power(int num1, int num2, long res) {
		if(num2 == 0)
			return res;
		res = res * num1;
		return power(num1, num2 - 1, res);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		
		long res = 1;
		res = power(num1, num2, res);
		System.out.println(res);
		scanner.close();
	}

}
