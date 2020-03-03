package com.app.dynamicprogramming.classroom;

import java.util.Arrays;

public class FibonacciTopDown {
	private static int findFib(int n, int []memo) {
		if(memo[n] == -1) {
			int res;
			if(n == 0 || n == 1)
				res = n;
			else
				res = findFib(n - 1, memo) + findFib(n - 2, memo);
			memo[n] = res;
		}
		return memo[n];
	}

	public static void main(String[] args) {
		int n = 8;
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		
		int val = findFib(n, memo);
		
		System.out.println("The " + n + "th fibonacci number is - " + val);

	}

}
