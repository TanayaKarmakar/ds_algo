package com.app.practice.math;

import java.util.Arrays;
import java.util.Scanner;

public class CountPrimesLeetcode204 {
	private static int countPrimes(int n) {
		if(n <= 2)
			return 0;
		boolean[] sieve = new boolean[n];
		Arrays.fill(sieve, true);

		int count = n - 2;
		for (int i = 2; i * i < n; i++) {
			for (int j = i; (j * i) < n; j++) {
				if (sieve[i * j]) {
					sieve[i * j] = false;
					count--;
				}	
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int ans = countPrimes(n);

		System.out.println(ans);

		scanner.close();
	}

}
