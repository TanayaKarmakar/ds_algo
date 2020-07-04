package com.app.nt2.problems;

import java.util.Scanner;

public class LCMSum {
	private static final int MAX = 1000002;
	private static int[] phi = new int[MAX];
	private static int[] ans = new int[MAX];
	
	private static void etf() {
		for(int i = 1; i < MAX; i++) {
			phi[i] = i;
		}
		
		for(int i = 2; i < MAX; i++) {
			if(phi[i] == i) {
				for(int j = i; j < MAX; j += i) {
					phi[j] = (phi[j] * (i - 1))/i;
				}
			}
		}
	}
	
	private static void preCompute() {
		etf();
		
		for(int i = 1; i < MAX; i++) {
			for(int j = i; j < MAX; j += i) {
				ans[j] += (i * phi[i]);
			}
		}
	}
	
	private static long gcd(long a, long b) {
		if(b == 0)
			return a;
		return gcd(b, a % b);
	}
	
	private static long findSum(long n) {
		long sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += (n * i) / gcd(n, i);
		}
		
		return sum;
	}

	public static void main(String[] args) {
		preCompute();
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
//		int answer = ans[n];
//		answer = ((answer + 1) * n) / 2;
//		
//		System.out.println(answer);
		
		long sum = findSum(n);
		
		System.out.println(sum);
		
		scanner.close();

	}

}
