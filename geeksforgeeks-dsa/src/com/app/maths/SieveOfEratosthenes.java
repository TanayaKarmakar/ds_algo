package com.app.maths;

public class SieveOfEratosthenes {
	private static void printPrimeNumbers(int n) {
		boolean[] primeSieve = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			primeSieve[i] = true;
		}
		primeSieve[0] = false;
		primeSieve[1] = false;

		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			for (int j = i * i; j <= n; j = j + i) {
				if (primeSieve[j]) {
					primeSieve[j] = false;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			if (primeSieve[i]) {
				System.out.print(i + "\t");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int n = 50;
		printPrimeNumbers(n);
	}

}
