package com.app.practice.dp;

import java.util.ArrayList;
import java.util.List;

public class WordBreakLeetcode139 {
	private static boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		boolean[] isWordBreak = new boolean[n + 1];

		isWordBreak[0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (!isWordBreak[j])
					continue;
				if (wordDict.contains(s.substring(j, i)))
					isWordBreak[i] = true;
			}
		}

		return isWordBreak[n];
	}

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");

		boolean ans = wordBreak(s, wordDict);

		System.out.println(ans);
	}

}
