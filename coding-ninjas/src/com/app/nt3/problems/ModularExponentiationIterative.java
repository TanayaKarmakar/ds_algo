package com.app.nt3.problems;

import java.util.Scanner;

public class ModularExponentiationIterative {
	private static int modExp(int a, int b, int c) {
		if(a == 0)
			return 0;
		if(b == 0)
			return 1;
		long ans = 1;
		
		while(b != 0) {
			if((b & 1) == 1) {
				ans = (ans * a) % c;
			}
			a = (a * a) % c;
			b = b / 2;
		}
		
		return (int)((ans + c) % c);
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
