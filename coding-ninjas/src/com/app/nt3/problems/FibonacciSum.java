package com.app.nt3.problems;

import java.util.Scanner;

public class FibonacciSum {
	private static final int MOD = 1000000007;

	private static void multiply(long[][] A, long[][] M) {
		long v1 = ((A[0][0] * M[0][0]) % MOD + (A[0][1] * M[1][0]) % MOD) % MOD;
		long v2 = ((A[0][0] * M[0][1]) % MOD + (A[0][1] * M[1][1]) % MOD) % MOD;
		long v3 = ((A[1][0] * M[0][0]) % MOD + (A[1][1] * M[1][0]) % MOD) % MOD;
		long v4 = ((A[1][0] * M[0][1]) % MOD + (A[1][1] * M[1][1]) % MOD) % MOD;
		
//		long v1 = (((A[0][0] % MOD) * (M[0][0] % MOD)) % MOD + ((A[0][1] % MOD) * (M[1][0] * MOD)) % MOD) % MOD;
//		long v2 = (((A[0][0] % MOD) * (M[0][1] % MOD)) % MOD + ((A[0][1] % MOD) * (M[1][1] * MOD)) % MOD) % MOD;
//		long v3 = (((A[1][0] % MOD) * (M[0][0] % MOD)) % MOD + ((A[1][1] % MOD) * (M[1][0] * MOD)) % MOD) % MOD;
//		long v4 = (((A[1][0] % MOD) * (M[0][1] % MOD)) % MOD + ((A[1][1] % MOD) * (M[1][1] * MOD)) % MOD) % MOD;
		
		A[0][0] = v1;
		A[0][1] = v2;
		A[1][0] = v3;
		A[1][1] = v4;
	}

	private static void power(long[][] A, long n) {
		if (n == 0 || n == 1)
			return;
		power(A, n / 2);
		multiply(A, A);

		if (n % 2 != 0) {
			long[][] M = { { 1, 1 }, { 1, 0 } };
			multiply(A, M);
		}
	}

	private static long fib(long n) {
		if (n == 0)
			return 0;
		long[][] A = { { 1, 1 }, { 1, 0 } };
		power(A, n - 1);
		return A[0][0];
	}

	private static long fiboSum(long m, long n) {
		long sumM = fib(m + 2);
		long sumN = fib(n + 1);
		return (sumM - sumN + MOD) % MOD;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		long m = scanner.nextLong();
		long n = scanner.nextLong();
		
		long ans = fiboSum(n, m);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
