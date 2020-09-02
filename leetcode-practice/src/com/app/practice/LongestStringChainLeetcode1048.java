package com.app.practice;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChainLeetcode1048 {
	private static int longestStringChain(String[] words) {
		int n = words.length;

		Arrays.sort(words, Comparator.comparingInt(String::length));

		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		int maxLen = Integer.MIN_VALUE;

		for (int i = n - 1; i >= 0; i--) {
			String source = words[i];
			for (int j = i - 1; j >= 0; j--) {
				String target = words[j];
				if(source.length() == target.length())
					continue;
				if (source.length() - target.length() >= 2)
					break;
				if (predecessor(source, target)) {
					dp[j] = Integer.max(dp[j], dp[i] + 1);
				}
				maxLen = Integer.max(maxLen, dp[j]);
			}
		}
		return maxLen;
	}

	private static boolean predecessor(String source, String target) {
		int srcIndx = 0;
		int targetIndx = 0;
		int count = 0;

		int n = target.length();
		while (targetIndx < n) {
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

	public static void main(String[] args) {
		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		int len = longestStringChain(words);
		
		System.out.println(len);
	}

}
