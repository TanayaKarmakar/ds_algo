package com.app.nt3.problems;

import java.util.Scanner;

public class CubicSquare {
	private static long calculate(long a, String b, long m) {
		long result = 1;
		int n = b.length();
		
		for(int i = n - 1; i >= 0; i--) {
			if(b.charAt(i) == '1') {
				result = (result * a) % m;
			}
			if(b.charAt(i) == '2') {
				result = (((result * a) % m) * a) % m;
			}
			
			a = (((a * a) % m) * a) % m;
		}
		
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			long a = scanner.nextInt();
			String b = scanner.next();
			long m = scanner.nextInt();
			
			long result = calculate(a, b, m);
			
			System.out.println(result);
		}

		scanner.close();
	}

}
