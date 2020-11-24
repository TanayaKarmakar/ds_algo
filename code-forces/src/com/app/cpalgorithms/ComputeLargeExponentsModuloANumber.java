package com.app.cpalgorithms;

import java.util.Scanner;

//compute (x ^ n) modulo m
public class ComputeLargeExponentsModuloANumber {
	private static long getAns(long a, long b, long m) {
		long res = 1;
		while (b > 0) {
			if ((b & 1) == 1) {
				res = (res * a) % m;
			}
			a = (a * a) % m;
			b = b >> 1;
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		long a = scanner.nextLong();
		long b = scanner.nextLong();
		long m = scanner.nextLong();

		long ans = getAns(a, b, m);

		System.out.println(ans);

		scanner.close();

	}

}
