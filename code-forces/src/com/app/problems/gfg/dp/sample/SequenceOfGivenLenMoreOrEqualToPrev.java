package com.app.problems.gfg.dp.sample;

import java.util.Scanner;

public class SequenceOfGivenLenMoreOrEqualToPrev {
	private static int count = 0;
	
	private static void countUtil(int curr, int m, int n) {
		if (n == 0) {
			count++;
			return;
		}
		if(m < n || n < 0)
			return;
		for (int j = 2 * curr; j <= m; j++) {
			countUtil(j, m, n - 1);
		}
	}

	private static int count(int m, int n) {
		count = 0;
		for(int i = 1; i <= (m / 2); i++) {
			countUtil(i, m, n - 1);
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		int count = count(m, n);
		
		System.out.println("Count - " + count);
		
		scanner.close();
	}

}
