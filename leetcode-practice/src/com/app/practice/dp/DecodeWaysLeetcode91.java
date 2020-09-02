package com.app.practice.dp;

import java.util.Scanner;

public class DecodeWaysLeetcode91 {
	private static int decodeWays(String s) {
		int n = s.length();
		int[] dp = new int[n + 1];
		
		dp[0] = 1;
		dp[1] = (s.charAt(0) == '0') ? 0: 1;
		
		for(int i = 2; i <= n; i++) {
			if(s.charAt(i - 1) != '0') {
				dp[i] += dp[i - 1];
			}
			if(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' 
					&& s.charAt(i - 1) < '7'))
				dp[i] += dp[i - 2];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.next();
		
		int ans = decodeWays(txt);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
