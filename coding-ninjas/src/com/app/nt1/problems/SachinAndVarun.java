package com.app.nt1.problems;

import java.util.Scanner;

class Triplet2 {
	long x;
	long y;
	long gcd;
}

public class SachinAndVarun {
	private static long gcd(long a, long b) {
		if(b == 0)
			return a;
		return gcd(b, a % b);
	}
	
	private static Triplet2 extendedEuclid(long a, long b) {
		if(b == 0) {
			Triplet2 triplet = new Triplet2();
			triplet.gcd = a;
			triplet.x = 1;
			triplet.y = 0;
			return triplet;
		}
		Triplet2 smallOutput = extendedEuclid(b, a % b);
		Triplet2 newAns = new Triplet2();
		newAns.gcd = smallOutput.gcd;
		newAns.x = smallOutput.y;
		newAns.y = smallOutput.x - (a / b) * smallOutput.y;
		return newAns;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			long a = scanner.nextInt();
			long b = scanner.nextInt();
			long d = scanner.nextInt();
			
			long g = gcd(Long.max(a, b), Long.min(a, b));
			
			if(d % g != 0) {
				System.out.println("0");
				continue;
			}
			
			if(d == 0) {
				System.out.println("1");
				continue;
			}
			
			a = a / g;
			b = b / g;
			d = d / g;
			
			long val = extendedEuclid(a, b).gcd;
			long y1 = ((d % a) * val) % a;
			long firstValue = (d / b);
			
			if(d < (y1 * b)) {
				System.out.println("0");
				continue;
			}
			
			long n = (firstValue - y1)/a;
			long ans = n + 1;
			
			System.out.println(ans);
			
		}

		scanner.close();
	}

}
