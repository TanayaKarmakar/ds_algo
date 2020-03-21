package com.app.bitmanipulation.problems;

public class FlipiThBit {
	private static int getResult(int num, int k) {
		int val = 1 << k;
		return (num ^ val); 
	}

	public static void main(String[] args) {
		int n = 11;
		int k = 2;
		int res = getResult(n, k);
		System.out.println(res);

	}

}
