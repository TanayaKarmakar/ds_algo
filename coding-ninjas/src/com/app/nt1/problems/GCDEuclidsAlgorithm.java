package com.app.nt1.problems;

import java.util.Scanner;

public class GCDEuclidsAlgorithm {
	private static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		int res = 0;
		if(a > b) {
			res = gcd(b, a);
		} else {
			res = gcd(a, b);
		}

		System.out.println("GCD - " + res);
		scanner.close();
	}

}
