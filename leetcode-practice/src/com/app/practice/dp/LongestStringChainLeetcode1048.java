package com.app.practice.dp;

import java.util.Arrays;

public class LongestStringChainLeetcode1048 {
	private static int longestStrChain(String[] words) {
		Arrays.sort(words, (e1, e2) -> e1.length() - e2.length());
		
		int n = words.length;
		int[] dp = new int[n];
		
		Arrays.fill(dp, 1);
		int maxVal = 1;
		
		for(int i = n - 1; i > 0; i--) {
			for(int j = i - 1; j >= 0; j--) {
				if(words[i].length() == words[j].length())
					continue;
				if(words[i].length() > words[j].length() + 1)
					break;
				if(isPredecessor(words[i], words[j])) {
					dp[j] = Integer.max(dp[j], dp[i] + 1);
					maxVal = Integer.max(maxVal, dp[j]);
				}
			}
		}
		return maxVal;
	}
	
	private static boolean isPredecessor(String source, String target) {
		int count = 0;
		int sIndx = 0;
		int tIndx = 0;
		int sLen = source.length();
		int tLen = target.length();
		
		while(sIndx < sLen && tIndx < tLen) {
			if(source.charAt(sIndx + count) == target.charAt(tIndx)) {
				tIndx++;
				sIndx++;
			} else {
				count++;
			}
			if(count > 1)
				return false;
			
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
		
		int ans = longestStrChain(words);
		
		System.out.println(ans);

	}

}
