package com.app.nt1.problems;

import java.util.Scanner;

public class AdvancedGCD {
	private static int convertInt(String a, int b) {
		int res = 0;
		int n = a.length();
		for(int i = 0; i < n; i++) {
			res = (res * 10 + (a.charAt(i) - '0') % b) % b;
		}
		return res;
	}
	
	private static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a % b);
	}
	
	private static int gcd(String a, int b) {
		int ia = convertInt(a, b);
		return gcd(ia, b);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			int b = scanner.nextInt();
			String a = scanner.next();
			if(b == 0) {
                System.out.println(a);
                continue;
            }
			
			int gcd = gcd(a, b);
			
			System.out.println(gcd);
		}
		
		scanner.close();
	}
}
