package com.app.nt3.problems;

import java.util.Scanner;

public class ModularExponentiationRecursive {
	private static int modExp(int a, int b, int c) {
		if (a == 0)
			return 0;
		if (b == 0)
			return 1;
		long ans;

		if (b % 2 == 0) {
			long smallAns = modExp(a, b / 2, c);
			ans = (smallAns * smallAns) % c;
		} else {
			long smallAns = modExp(a, b - 1, c);
			ans = (a % c);
			ans = (ans * smallAns) % c;
		}

		return (int) ((ans + c) % c);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		int ans = modExp(a, b, c);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
