package com.app.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostFrequentWordLeetcode819 {
	private static String mostFrequentWord(String paragraph, String[] bannedWords) {
		if(paragraph.isEmpty())
			return "";
		paragraph = paragraph.toLowerCase();
		paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " ");
		String[] pArr = paragraph.split("\\s+");
		Set<String> bannedWordsSet = new HashSet<>();
		for(String word: bannedWords) {
			bannedWordsSet.add(word);
		}
		
		Map<String, Integer> map = new HashMap<>();
		int maxFreq = Integer.MIN_VALUE;
		String maxFreqWord = "";
		for(String word: pArr) {
			if(!bannedWordsSet.contains(word)) {
				map.put(word, map.getOrDefault(word, 0) + 1);
				if(map.get(word) > maxFreq) {
					maxFreq = map.get(word);
					maxFreqWord = word;
				}
			}
		}
		
		return maxFreqWord;
	}

	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		
		System.out.println(mostFrequentWord(paragraph, banned));

	}

}
