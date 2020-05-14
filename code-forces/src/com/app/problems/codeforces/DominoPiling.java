package com.app.problems.codeforces;

import java.util.Scanner;

public class DominoPiling {
	private static int getMax(int m, int n) {
		return (m * n)/2;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		int ans = getMax(m, n);

		System.out.println(ans);
		scanner.close();
	}

}
