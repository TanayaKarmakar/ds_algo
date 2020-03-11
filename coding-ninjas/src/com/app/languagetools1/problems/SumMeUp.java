package com.app.languagetools1.problems;

import java.util.Scanner;

public class SumMeUp {
	private static long sum(long num) {
		long tmp = num;
		long sum = 0;
		while (tmp > 0) {
			long r = tmp % 10;
			sum += r;
			tmp = tmp / 10;
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = Integer.parseInt(scanner.nextLine());
		long[] res = new long[nTestCases];
		int indx = 0;
		while (nTestCases > 0) {
			long num = Long.parseLong(scanner.nextLine());
			long sum = sum(num);
			res[indx++] = sum;
			nTestCases--;
		}
		
		for(Long s: res) {
			System.out.println(s);
		}
		scanner.close();
	}
}
