package com.app.questions.practice;

import java.util.Arrays;
import java.util.List;

public class WorkBreakProblemLeetcode139 {
	private static boolean isWordBreak(String str, List<String> wordDict) {
		int n = str.length();
		
		boolean isWordBreak[] = new boolean[n + 1];
		
		isWordBreak[0] = true;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				if(!isWordBreak[j])
					continue;
				if(wordDict.contains(str.substring(j, i))) {
					isWordBreak[i] = true;
					break;
				}
			}
		}
		return isWordBreak[n];
	}

	public static void main(String[] args) {
		String s = "leetcode";
		System.out.println(isWordBreak(s, Arrays.asList("leet", "code")));
		
		s = "applepenapple";
		
		System.out.println(isWordBreak(s, Arrays.asList("apple", "pen")));

	}

}
