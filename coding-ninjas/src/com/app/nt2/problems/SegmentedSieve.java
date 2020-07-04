package com.app.nt2.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SegmentedSieve {
	private static final int MAX = 100001;
	
	private static List<Integer> sieve() {
		boolean[] sieve = new boolean[MAX];
		Arrays.fill(sieve, true);
		
		sieve[0] = false;
		sieve[1] = false;
		
		for(int i = 2; i * i < MAX; i++) {
			if(sieve[i] == true) {
				for(int j = i * i; j < MAX; j += i) {
					//System.out.println(j);
					sieve[j] = false;
				}
			}
		}
		
		List<Integer> res = new ArrayList<>();
		res.add(2);
		for(int i = 3; i < MAX; i += 2) {
			if(sieve[i] == true) {
				res.add(i);
			}
		}
		
		return res;
	}
	
	private static void printPrimes(long l, long r, List<Integer> primes) {
		int size = (int)(r - l + 1);
		boolean[] prime = new boolean[size];
		
		Arrays.fill(prime, true);
		
		for(int i = 0; (long)(primes.get(i) * primes.get(i)) <= r; i++) {
			int currentPrime = primes.get(i);
			
			long base = (l / currentPrime) * currentPrime;
			if(base < l) {
				base = base + currentPrime;
			}
			
			for(long j = base; j <= r; j += currentPrime) {
				prime[(int)(j - l)] = false;
			}
			
			if(base == currentPrime)
				prime[(int)(base - l)] = true;
		}
		
		for(int i = 0; i < size; i++) {
			if(prime[i] == true) {
				System.out.println(i + l);
			}
		}
	}

	public static void main(String[] args) {
		List<Integer> primes = sieve();
		Scanner scanner = new Scanner(System.in);
		
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			printPrimes(l, r, primes);
		}

		scanner.close();
	}

}
