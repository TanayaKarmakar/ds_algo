package com.app.premitive;

import java.util.Scanner;

public class SwapiThAndjThBit {
	private static long swapBits(long num, int i, int j) {
		long iThBit = (num >> i) & 1;
		long jThBit = (num >> j) & 1;

		if (iThBit == jThBit)
			return num;
		long mask = (1 << i) | (1 << j);
		return (num ^ mask);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long num = scanner.nextLong();
		int i = scanner.nextInt();
		int j = scanner.nextInt();

		long ans = swapBits(num, i, j);
		System.out.println(ans);
		scanner.close();
	}

}
