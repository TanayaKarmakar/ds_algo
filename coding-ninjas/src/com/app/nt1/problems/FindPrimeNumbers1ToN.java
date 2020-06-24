package com.app.nt1.problems;

import java.util.Scanner;

public class FindPrimeNumbers1ToN {
	private static boolean isPrime(int n) {
		int count = 0;
		for(int i = 1; i * i <= n; i++) {
			if(n % i == 0) {
				if(i * i == n)
					count++;
				else
					count+= 2;
			}		
		}
		return count == 2;
	}
	
	private static int countOfPrime(int n) {
		int count = 0;
		for(int i = 2; i <= n; i++) {
			if(isPrime(i))
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int count = countOfPrime(n);
		System.out.println(count);
		scanner.close();
	}

}
