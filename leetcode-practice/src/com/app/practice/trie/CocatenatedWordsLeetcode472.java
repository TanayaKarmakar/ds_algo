package com.app.practice.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CocatenatedWordsLeetcode472 {
	private static boolean canBreak(String word, Set<String> wordDictSet) {
		int n = word.length();
		boolean[] isWordBreak = new boolean[n + 1];

		isWordBreak[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (!isWordBreak[j])
					continue;
				if (wordDictSet.contains(word.substring(j, i))) {
					isWordBreak[i] = true;
				}
			}
		}

		return isWordBreak[n];
	}

	private static List<String> findAllConcatenatedWordsInADict(String[] words) {
		if (words.length == 0)
			return new ArrayList<>();

		Set<String> wordDictSet = new HashSet<>();
		for (String word : words) {
			wordDictSet.add(word);
		}

		List<String> res = new ArrayList<>();
		for (String word : words) {
			if (word.equals(""))
				continue;
			wordDictSet.remove(word);
			if (canBreak(word, wordDictSet)) {
				res.add(word);
			}
			wordDictSet.add(word);
		}

		return res;
	}

	public static void main(String[] args) {
		String[] words = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
		List<String> res = findAllConcatenatedWordsInADict(words);
		
		System.out.println(res);
	}

}
