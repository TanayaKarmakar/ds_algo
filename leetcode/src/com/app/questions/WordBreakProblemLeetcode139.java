package com.app.questions;

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
				
				if(wordDict.contains(s.substring(j, i))) {
					wordBreak[i] = true;
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(wordBreak));
		return wordBreak[n];
	}

	public static void main(String[] args) {
		String s = "applepenapple";
		
		List<String> dict = Arrays.asList("apple","pen");
		
		System.out.println(wordBreak(s, dict));

	}

}
