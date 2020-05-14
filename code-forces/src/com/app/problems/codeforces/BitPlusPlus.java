package com.app.problems.codeforces;

import java.util.Scanner;

public class BitPlusPlus {
	private static int x = 0;
	private static void getVal(String str) {
		if(str.indexOf("++") >=0) {
			x += 1;
		} else if(str.indexOf("--") >= 0) {
			x -= 1;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		x = 0;
		while(n > 0) {
			String op = scanner.next();
			getVal(op);
			n--;
		}
		System.out.println(x);
		scanner.close();

	}

}
