package com.app.practice.dp;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChainLeetcode1048 {
	private static boolean isPredecessor(String source, String target) {
		int srcIndx = 0;
		int targetIndx = 0;
		int count = 0;

		while (targetIndx < target.length()) {
			if (source.charAt(srcIndx + count) != target.charAt(targetIndx)) {
				count++;
				if (count > 1)
					return false;
			} else {
				targetIndx++;
				srcIndx++;
			}
		}

		return true;
	}

	private static int longestStringChain(String[] words) {
		Arrays.sort(words, Comparator.comparingInt(String::length));

		int n = words.length;
		int[] dp = new int[n];

		int maxLen = 1;

		dp[n - 1] = 1;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (words[i].length() == words[j].length())
					continue;
				if ((words[i].length() - words[j].length()) > 1)
					break;
				if (isPredecessor(words[i], words[j])) {
					dp[j] = Integer.max(dp[j], 1 + dp[i]);
				}
				maxLen = Integer.max(maxLen, dp[j]);
			}
		}

		return maxLen;
	}

	public static void main(String[] args) {
		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		
		int maxLen = longestStringChain(words);
		
		System.out.println(maxLen);
	}

}
