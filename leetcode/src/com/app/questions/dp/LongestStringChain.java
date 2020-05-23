package com.app.questions.dp;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
	private static int maxLen(String[] words) {
		Arrays.sort(words, Comparator.comparingInt(String:: length));
		int n = words.length;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 1);
		
		int max = Integer.MIN_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			String currentWord = words[i];
			
			for(int j = i - 1;j>=0;j--) {
				String str = words[j];
				if(currentWord.length() == str.length())
					continue;
				if(currentWord.length() != str.length() + 1)
					break;
				
				if(isPredecessor(currentWord, str)) {
					dp[j] = Integer.max(dp[j], dp[i] + 1);
				}
				
				max = Integer.max(max, dp[j]);
			}
		}
		//System.out.println(Arrays.toString(dp));

		return max == Integer.MIN_VALUE ? 1: max;
	}
	
	private static boolean isPredecessor(String source, String target) {
		int sourceIndx = 0;
		int targetIndx = 0;
		int count = 0;
		
		while(targetIndx < target.length()) {
			if(count > 1)
				return false;
			if(target.charAt(targetIndx) != source.charAt(sourceIndx + count)) {
				count++;
			} else {
				sourceIndx++;
				targetIndx++;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		//String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		String[] words = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
		int max = maxLen(words);
		System.out.println(max);
	}

}
