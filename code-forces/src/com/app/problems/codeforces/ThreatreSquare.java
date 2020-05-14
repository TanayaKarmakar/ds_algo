package com.app.problems.codeforces;

import java.util.Scanner;

public class ThreatreSquare {
	private static long getMin(long n, long m, long a) {
		long nW = (n / a) + (n % a == 0 ? 0: 1);
		long nH = (m / a) + (m % a == 0 ? 0: 1);
		return nW * nH;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong();
		long a = scanner.nextLong();
		
		long ans = getMin(n, m, a);
		System.out.println(ans);
		
		scanner.close();

	}

}
