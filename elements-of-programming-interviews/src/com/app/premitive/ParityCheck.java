package com.app.premitive;

import java.util.Scanner;

public class ParityCheck {
	//64 bit number
	private static int parityEfficient(long x) {
		x = x ^ (x >> 32);
		x = x ^ (x >> 16);
		x = x ^ (x >> 8);
		x = x ^ (x >> 4);
		x = x ^ (x >> 2);
		x = x ^ (x >> 1);
		
		return (int)(x & 1);
	}
	
	private static int parity(long x) {
		int count = 0;
		while (x != 0) {
			count++;
			x = x & (x - 1);
		}

		if (count % 2 == 0)
			return 0;
		else
			return 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long x = scanner.nextLong();

		int ans = parity(x);

		System.out.println("Parity - " + ans);
		
		ans = parityEfficient(x);
		
		System.out.println("Parity Efficient - " + ans);
		scanner.close();

	}

}
