package com.app.problems.codeforces;

import java.util.Scanner;

public class WaterMelon {
	private static boolean canDivide(int n) {
		return (n != 2 && n % 2 == 0);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		if(canDivide(n)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		scanner.close();
	}

}
