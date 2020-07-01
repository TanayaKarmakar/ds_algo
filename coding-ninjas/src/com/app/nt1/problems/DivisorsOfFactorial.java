package com.app.nt1.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DivisorsOfFactorial {
	private static final int MAX = 500001;
	private static final int MOD = 1000000007;
	
	private static long getDivisors(int n, List<Integer> primes) {
		long result = 1;
		for(int i = 0; primes.get(i) <= n; i++) {
			long count = 0;
			int k = primes.get(i);
			
			while((n / k) != 0) {
				count = (count + (n / k)) % MOD;
				k = k * primes.get(i);
			}
			
			result = (result * ((count + 1) % MOD)) % MOD;
		}
		return result;
	}
	
	private static List<Integer> getAllPrimes() {
		boolean isPrime[] = new boolean[MAX];
		
		Arrays.fill(isPrime, true);
		for(int i = 2; i * i < MAX; i++) {
			if(isPrime[i]) {
				for(int j = i * i; j < MAX; j+= i) {
					isPrime[j] = false;
				}
			}	
		}
		
		List<Integer> ans = new ArrayList<>();
		ans.add(2);
		for(int i = 3; i < MAX; i++) {
			if(isPrime[i]) {
				ans.add(i);
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		List<Integer> primes = getAllPrimes();
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			int val = scanner.nextInt();
			long res = getDivisors(val, primes);
			
			System.out.println(res);
		}
		
		scanner.close();
	}

}
