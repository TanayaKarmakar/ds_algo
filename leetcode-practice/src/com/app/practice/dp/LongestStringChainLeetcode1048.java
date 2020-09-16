package com.app.practice.dp;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChainLeetcode1048 {
	private static boolean isPredecessor(String source, String target) {
		int srcIndx = 0;
		int targetIndx = 0;
		int count = 0;
		while (targetIndx < target.length()) {
			if (count > 1)
				return false;
			if (source.charAt(srcIndx + count) != target.charAt(targetIndx)) {
				count++;
			} else {
				srcIndx++;
				targetIndx++;
			}
		}

		return true;
	}

	private static int longestStrChain(String[] words) {
		Arrays.sort(words, Comparator.comparingInt(String:: length));
		int n = words.length;
		int[] dp = new int[n];

		int maxLen = 1;
		dp[n - 1] = 1;
		
		Arrays.fill(dp, 1);
		for (int i = n - 1; i >= 0; i--) {
			String source = words[i];
			for (int j = i - 1; j >= 0; j--) {
				String target = words[j];
				if (source.length() == target.length())
					continue;
				if (source.length() - target.length() > 1)
					break;
				if (isPredecessor(source, target)) {
					dp[j] = Integer.max(dp[i] + 1, dp[j]);
				}
				maxLen = Integer.max(maxLen, dp[j]);
			}
		}

		return maxLen;
	}

	public static void main(String[] args) {
		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		
		int maxLen = longestStrChain(words);
		
		System.out.println(maxLen);
	}

}
