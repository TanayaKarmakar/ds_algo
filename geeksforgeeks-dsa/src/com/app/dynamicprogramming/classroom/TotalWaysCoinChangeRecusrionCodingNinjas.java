package com.app.dynamicprogramming.classroom;

public class TotalWaysCoinChangeRecusrionCodingNinjas {
	private static int numChange(int n, int[] coins, int k, int startIndx) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (k == 0)
			return 0;

		int option1 = numChange(n - coins[startIndx], coins, k, startIndx);
		int option2 = numChange(n, coins, k - 1, startIndx + 1);
		return option1 + option2;
	}

	public static void main(String[] args) {
		int n = 4;
		int[] coins = { 1, 2 };
		int numWays = numChange(n, coins, 2, 0);
		
		System.out.println("Total Number of options - " + numWays);
	}

}
