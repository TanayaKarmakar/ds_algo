package com.app.nt1.problems;

import java.util.Arrays;
import java.util.Scanner;

public class First1toNPrimeNumbersSieveOfEratosthenes {
	
	private static int countPrimes(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		
		for(int i = 2; i * i <= n; i++) {
			if(primes[i] == true) {
				int j = i;
				while((i * j) <= n) {
					primes[(i * j)] = false;
					j++;
				}
			}	
		}
		
		int count = 0;
		for(int i = 2; i <= n; i++) {
			if(primes[i] == true)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int count = countPrimes(n);
		System.out.println(count);
		scanner.close();
	}

}
