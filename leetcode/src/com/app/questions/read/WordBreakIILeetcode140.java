package com.app.questions.read;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakIILeetcode140 {
	private static List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<>();
		for(String word: wordDict) {
			wordDictSet.add(word);
		}
		
		Map<String, List<List<String>>> memo = new HashMap<>();
		wordBreak(s, memo, wordDictSet);
		
		List<String> result = new ArrayList<>();
		
		List<List<String>> items = memo.get(s);
		
		for(List<String> item: items) {
			StringBuilder sb = new StringBuilder();
			for(String str: item) {
				sb.append(str);
				sb.append(" ");
			}
			result.add(sb.toString());
		}
		
		return result;
		
	}
	
	private static List<List<String>> wordBreak(String s, Map<String, List<List<String>>> map, Set<String> wordDictSet) {
		if(s.equals("")) {
			List<List<String>> sentences = new ArrayList<>();
			List<String> word = new ArrayList<>();
			sentences.add(word);
			return sentences;
		}
		
		if(map.containsKey(s))
			return map.get(s);
		else {
			List<List<String>> val = new ArrayList<>();
			map.put(s, val);
		}
		
		for(int endIndx = 1; endIndx <= s.length(); endIndx++) {
			String word = s.substring(0, endIndx);
			if(wordDictSet.contains(word)) {
				List<List<String>> smallOutput = wordBreak(s.substring(endIndx), map, wordDictSet);
				for(List<String> item: smallOutput) {
					List<String> newItem = new ArrayList<>(item);
					newItem.add(0, word);
					map.get(s).add(newItem);
				}
			}
		}
		
		return map.get(s);
	}

	public static void main(String[] args) {
		String str = "catsanddog";
		
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
		
		List<String> output = wordBreak(str, wordDict);
		
		System.out.println(output);
		
		str = "pineapplepenapple";
		
		wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
		
		output = wordBreak(str, wordDict);
		
		System.out.println(output);
		
		str = "catsandog";
		
		wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
		
		output = wordBreak(str, wordDict);
		
		System.out.println(output);
	}

}
