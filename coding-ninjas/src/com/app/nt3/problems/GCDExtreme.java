package com.app.nt3.problems;

import java.util.Scanner;

public class GCDExtreme {
	private static int[] phi;
	private static long[] s;
	private static final int MAX = 10000001;

	private static void preCalculate() {
		phi = new int[MAX + 10];
		s = new long[MAX + 10];

		phi[1] = 1;
		for (int i = 2; i <= 1000000; i++) {
			if (phi[i] == 0) {
				phi[i] = i - 1;
				for (int j = i + i; j <= 1000000; j += i) {
					if (phi[j] == 0)
						phi[j] = j;
					phi[j] = phi[j] - phi[j] / i;
				}
			}
		}

		for (int i = 1; i <= 1000000; i++) {
			for (int j = i + i; j <= 1000000; j += i) {
				s[j] = s[j] + (i * phi[j / i]);
			}
		}

		for (int i = 1; i <= 1000000; i++)
			s[i] = s[i] + s[i - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		preCalculate();

		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			System.out.println(s[n]);
		}

		scanner.close();
	}

}
