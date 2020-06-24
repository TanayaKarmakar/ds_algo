package com.app.dpbitmasking.problems;

import java.util.Arrays;
import java.util.Scanner;

class Pair implements Comparable<Pair> {
	long first;
	long second;

	@Override
	public int compareTo(Pair o) {
		if (this.first < o.first)
			return -1;
		else if (this.first > o.first)
			return 1;
		else
			return 0;
	}
}

public class MehtaAndBankRobbery {
	private static long maxProfit(Pair[] items, int n, int w) {
		int[] primes = { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
		long[][][] dp = new long[2][n + 1][w + 1];
		
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j<= w; j++) {
				dp[0][i][j] = dp[0][i - 1][j];
				if(j >= items[i - 1].second) {
					dp[0][i][j] = Long.max(dp[0][i][j], 
							dp[0][i - 1][j - (int)items[i - 1].second] + items[i - 1].first);
				}
			}
		}
		
		for(int prime = 1; prime <= 10; prime++) {
			int p = prime % 2;
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= w; j++) {
					dp[p][i][j] = dp[p][i - 1][j];
					if(j >= items[i - 1].second) {
						long option1 = dp[p][i][j];
						long option2 = dp[p][i - 1][j - (int)items[i - 1].second] 
								+ items[i - 1].first;
						long option3 = dp[p ^ 1][i - 1][j - (int)items[i - 1].second]
								+ items[i - 1].first * primes[prime];
						dp[p][i][j] = Long.max(option1, Long.max(option2, option3));
					}
				}
			}
		}
		return dp[0][n][w];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int w = scanner.nextInt();

		Pair[] items = new Pair[n];
		for (int i = 0; i < n; i++) {
			items[i] = new Pair();
			items[i].first = scanner.nextLong();
			items[i].second = scanner.nextLong();
		}

		Arrays.sort(items);
		
		long maxProfit = maxProfit(items, n, w);
		
		System.out.println(maxProfit);

		scanner.close();
	}

}
