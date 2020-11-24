package com.app.cpalgorithms;

import java.util.Scanner;

public class BinaryExponentiation {
	private static long recursion1(int a, int n) {
		if (n == 0)
			return 1;
		if (n % 2 == 0)
			return recursion1(a, n / 2) * recursion1(a, n / 2);
		else
			return a * recursion1(a, (n - 1) / 2) 
					* recursion1(a, (n - 1)/ 2);
	}
	
	private static int iteration(int a, int n) {
		int res = 1;
		int b = n;
		while(b != 0) {
			if((b & 1) == 1) {
				res = res * a;
			}
			a = a * a;
			b = b >> 1;
		}
		
		return res;
	}
	
	private static long recursion2(int a, int n) {
		if(n == 0)
			return 1;
		long power = recursion2(a, n / 2);
		if(n % 2 == 0)
			return (power * power);
		else
			return (long)(a * power * power);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a = scanner.nextInt();
		
		long ans = recursion1(a, n);
		
		System.out.println("Tail Recursion - " + ans);
		
		ans = iteration(a, n);
		
		System.out.println("Iteration - " + ans);
		
		ans = recursion2(a, n);
		
		System.out.println("Recursion2 - " + ans);
		
		scanner.close();

	}

}
