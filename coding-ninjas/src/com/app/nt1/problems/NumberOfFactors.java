package com.app.nt1.problems;

import java.util.Scanner;

public class NumberOfFactors {
	private static final int MAX = 1000001;
	private static final int MAX_N = 10;
	
	private static int[] preCompute() {
		int[] sieve = new int[MAX];
		for(int i = 2; i < MAX; i++) {
			if(sieve[i] == 0) {
				for(int j = i; j < MAX; j+= i) {
					sieve[j]++;
				}
			}
		}
		
		return sieve;
	}
	
	private static int[][] createRangeMatrix(int[] sieve) {
		int[][] rangeMat = new int[MAX_N + 1][MAX];
		
		for(int i = 1; i <= MAX_N; i++) {
			for(int j = 2; j < MAX; j++) {
				if(sieve[j] == i) {
					rangeMat[i][j] = rangeMat[i][j - 1] + 1;
				} else {
					rangeMat[i][j] = rangeMat[i][j - 1];
				}
			}
		}
		
		return rangeMat;
	}

	public static void main(String[] args) {
		int[] sieve = preCompute();
		int[][] rangeMat = createRangeMatrix(sieve);
		
		Scanner scanner = new Scanner(System.in);
		
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int n = scanner.nextInt();
			int val = rangeMat[n][b] - rangeMat[n][a - 1];
			System.out.println(val);
		}

		scanner.close();
	}

}
