package com.app.nt1.problems;

import java.util.Arrays;
import java.util.Scanner;

public class CubeFreeNumber {
	private static final int MAX = 1000001;
	
	private static int[] buildSieve() {
		int[] sieve = new int[MAX];
		for(int i = 2; i <= 100; i++) {
			int start = (i * i * i);
			int j = 1;
			while(start < MAX) {
				sieve[start * j] = -1;
				j++;
			}
		}
		
		int count = 1;
		for(int i = 1; i < MAX; i++) {
			if(sieve[i] != -1) {
				sieve[i] = count++;
			}
		}
		
		return sieve;
	}

	public static void main(String[] args) {
		int[] sieve = buildSieve();
		
		//System.out.println(Arrays.toString(sieve));
		
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		int i = 1;
		
		while(i < nTestCases + 1) {
			int n = scanner.nextInt();
			
			System.out.println("Case " + i + ": " 
			+ (sieve[n] == -1 ? "Not Cube Free": sieve[n]));
			i++;
		}

		scanner.close();
	}

}
