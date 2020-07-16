package com.app.nt3.problems;

//calculate Nth Fibonacci Number in log(n) time

public class NthFibonacciNumber {
	private static void multiply(int[][] A, int[][] M) {
		int v1 = A[0][0] * M[0][0] + A[0][1] * M[1][0];
		int v2 = A[0][0] * M[0][1] + A[0][1] * M[1][1];
		int v3 = A[1][0] * M[0][0] + A[1][1] * M[1][0];
		int v4 = A[1][0] * M[0][1] + A[1][1] * M[1][1];
		
		A[0][0] = v1;
		A[0][1] = v2;
		A[1][0] = v3;
		A[1][1] = v4;
	}
	
	private static void power(int[][] A, int n) {
		if (n == 0 || n == 1)
			return;
		power(A, n / 2);
		multiply(A, A);

		if ((n % 2) != 0) {
			int[][] M = { { 1, 1 }, { 1, 0 } };
			multiply(A, M);
		}
	}

	private static int nThFib(int n) {
		if (n == 0)
			return 0;
		int[][] A = { { 1, 1 }, { 1, 0 } };
		power(A, n - 1);

		return A[0][0];
	}

	public static void main(String[] args) {
		int n = 8;
		
		int ans = nThFib(n);
		
		System.out.println(ans);
	}

}
