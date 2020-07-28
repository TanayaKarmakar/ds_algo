package com.app.problems.gfg.dp.sample;

import java.util.Arrays;
import java.util.Scanner;

public class GolombSequence {
	private static int[] goLombSeq(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		int pos = 2;
		
		for(int i = 2; i <= n; i++) {
			dp[pos] = i;
			int count = dp[i];
			if(pos + 1 > n)
				break;
			for(int j = pos + 1; j < pos + count; j++) {
				dp[j] = dp[pos];
			}
			pos = (pos + count);
			if(pos > n)
				break;
		}
		
		return dp;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] res = goLombSeq(n);
		
		System.out.println(Arrays.toString(res));
		
		scanner.close();
	}

}
