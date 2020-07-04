package com.app.nt1.problems;

import java.util.Scanner;
import java.util.TreeSet;

public class NumberOfGoodSets {
	private static final int MAX = 750001;
	private static final int MOD = 1000000007;
	
	private static int numberOfGoodSets(int[] sieve, TreeSet<Integer> numSet) {
		for(int num: numSet) {
			for(int j = 2 * num; j < MAX; j+= num) {
				if(numSet.contains(j)) {
					sieve[j] = (sieve[j] + sieve[num]) % MOD;
				}
			}
		}
		
		int totalCount = 0;
		for(int num: numSet) {
			totalCount = (totalCount + sieve[num]) % MOD;
		}
		
		return totalCount;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			int[] sieve = new int[MAX];
			TreeSet<Integer> numSet = new TreeSet<>();
			for(int i = 0; i < n; i++) {
				int num = scanner.nextInt();
				sieve[num] = 1;
				numSet.add(num);
			}
			
			int totalCount = numberOfGoodSets(sieve, numSet);
			System.out.println(totalCount);
		}

		scanner.close();
	}

}
