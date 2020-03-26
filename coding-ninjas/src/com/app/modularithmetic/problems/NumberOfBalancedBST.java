package com.app.modularithmetic.problems;

public class NumberOfBalancedBST {
	private static final int MOD = 1000000007;
	private static long numberOfBST(int h) {
		if(h == 0 || h == 1)
			return 1;
		long x = numberOfBST(h - 1);
		long  y = numberOfBST(h - 2);
		long part1 = ((x % MOD) * (x % MOD))%MOD;
		long part2 =  ((x % MOD) * (y % MOD))%MOD;
		part2 = ((2 % MOD) * (part2 % MOD)) % MOD;
		return ((part1 % MOD) + (part2 % MOD)) % MOD;
	}
	
	private static int getCount(int h) {
		return (int)numberOfBST(h);
	}

	public static void main(String[] args) {
		int h = 6;
		
		long number = getCount(h);
		
		System.out.println(number);

	}

}
