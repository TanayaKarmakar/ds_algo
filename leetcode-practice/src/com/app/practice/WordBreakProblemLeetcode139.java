package com.app.practice;

import java.util.Arrays;
import java.util.List;

public class WordBreakProblemLeetcode139 {
	private static boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		boolean[] wordBreak = new boolean[n + 1];
		
		wordBreak[0] = true;
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				if(!wordBreak[j])
					continue;
				
				if(wordDict.contains(s.subSequence(j, i))) {
					wordBreak[i] = true;
				}
			}
		}
		
		return wordBreak[n];
	}

	public static void main(String[] args) {
		String s = "leetcode";
		
		List<String> wordDict = Arrays.asList("leet", "code");
		boolean isWordBreak = wordBreak(s, wordDict);
		
		System.out.println(isWordBreak);
		
		s = "applepenapple";
		
		wordDict = Arrays.asList("apple", "pen");
		
		isWordBreak = wordBreak(s, wordDict);
		
		System.out.println(isWordBreak);
		
		s = "catsandog";
		
		wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
	
		isWordBreak = wordBreak(s, wordDict);
		
		System.out.println(isWordBreak);
	}

}
