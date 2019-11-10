package com.app.maths;

import java.util.Arrays;

public class ExactlyThreeDivisors {
	private static int exactlyThreeDivisors(int num) {
		boolean[] primeSieve = generatePrimeUptoN(num);
		int j = 2;
		int count = 0;
		while ((j * j) <= num) {
			if (primeSieve[j] == true) {
				count++;
			}
			j++;
		}
		return count;
	}

	private static boolean[] generatePrimeUptoN(int num) {
		boolean[] primeSieve = new boolean[num + 1];
		Arrays.fill(primeSieve, true);

		primeSieve[0] = false;
		primeSieve[1] = false;

		int range = (int) Math.floor(Math.sqrt(num));

		for (int i = 2; i < range; i++) {
			for (int j = (i * i); j <= num; j = j + i) {
				if (!primeSieve[j]) {
					primeSieve[j] = false;
				}
			}
		}

		return primeSieve;
	}

	public static void main(String[] args) {
		int n = 10;
		System.out.println(exactlyThreeDivisors(n));
	}
}
