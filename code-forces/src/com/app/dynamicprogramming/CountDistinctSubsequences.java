package com.app.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctSubsequences {
	private static long getCount(String str) {
		int n = str.length();
		long[] dp = new long[n + 1];
		dp[0] = 1;
		
		Map<Character, Integer> lastOcc = new HashMap<>();
		for(int i = 1; i <= n; i++) {
			dp[i] = 2 * dp[i - 1];
			char ch = str.charAt(i - 1);
			if(lastOcc.containsKey(ch)) {
				int j = lastOcc.get(ch);
				dp[i] = dp[i] - dp[j - 1];
			}
			lastOcc.put(ch, i);
		}
		
		return dp[n] - 1;
	}

	public static void main(String[] args) {
		String str = "abcbac";
		
		long ans = getCount(str);
		
		System.out.println(ans);

	}

}
