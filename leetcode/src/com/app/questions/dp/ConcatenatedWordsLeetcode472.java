package com.app.questions.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConcatenatedWordsLeetcode472 {	
	private static List<List<String>> wordBreakRec(String word, Map<String, List<List<String>>> memo, Set<String> wordDictSet) {
		if(word.equals("")) {
			List<List<String>> res = new ArrayList<>();
			List<String> item = new ArrayList<>();
			res.add(item);
			return res;
		}
		
		if(memo.containsKey(word))
			return memo.get(word);
		else {
			memo.put(word, new ArrayList<>());
		}
		
		for(int endIndx = 1; endIndx <= word.length(); endIndx++) {
			String w = word.substring(0, endIndx);
			if(wordDictSet.contains(w)) {
				List<List<String>> smallOutput = wordBreakRec(word.substring(endIndx), memo, wordDictSet);
				for(List<String> item: smallOutput) {
					List<String> newItem = new ArrayList<>(item);
					newItem.add(0, w);
					memo.get(word).add(newItem);
				}
			}		
		}
		
		return memo.get(word);
	}
	
	private static List<List<String>> getWordBreak(String word, Set<String> wordDictSet) {
		Map<String, List<List<String>>> memo = new HashMap<>();
		
		wordBreakRec(word, memo, wordDictSet);
		return memo.get(word);
	}

	private static List<String> findAllConcatenatedWordsInADict(String[] words) {
		if(words.length <= 1)
			return new ArrayList<>();
		Set<String> wordDictSet = new HashSet<>();
		for (String word : words) {
			wordDictSet.add(word);
		}

		List<String> res = new ArrayList<>();
		for (String word : words) {
			if(word.equals(""))
                continue;
			List<List<String>> wordBreakList = getWordBreak(word, wordDictSet);
			if(!wordBreakList.isEmpty() && wordBreakList.size() > 1) {
				res.add(word);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String[] words = { "cat", "cats", "catsdogcats", "dog", 
				"dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
		
		List<String> result = findAllConcatenatedWordsInADict(words);
		
		System.out.println(result);

	}

}
