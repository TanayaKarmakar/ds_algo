package com.app.dp2.problems;

import java.util.Arrays;
import java.util.Scanner;

public class DistinctSubsequences {
	private static int findCount(String str) {
		int[] charOcc = new int[256];
		Arrays.fill(charOcc, -1);
		
		int n = str.length();
		int[] dp = new int[n + 1];
		dp[0] = 1;
		
		
		for(int i = 1; i <= n; i++) {
			dp[i] = 2 * dp[i - 1];
			if(charOcc[(int)str.charAt(i - 1)] != -1) {
				int val = charOcc[(int)str.charAt(i - 1)];
				dp[i] -= dp[val];
			}
			charOcc[(int)str.charAt(i - 1)] = (i - 1);
		}
		return dp[n];
	}

	public static void main(String[] args) {
//		String str = "";
//		int ans = findCount(str);
//		System.out.println(ans);
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		while(n > 0) {
			String str = scanner.next();
			int ans = findCount(str);
			System.out.println(ans);
			n--;
		}
		scanner.close();
	}

}
