package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWordLeetcode819 {
	private static String mostCommonWord(String paragraph, String[] banned) {
		paragraph = paragraph.toLowerCase();
		paragraph = paragraph.replaceAll("[^a-z]", " ");

		Map<String, Integer> map = new HashMap<>();
		String[] pArr = paragraph.split("\\s+");

		for (String word : pArr) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		for (String bannedWord : banned) {
			map.remove(bannedWord);
		}

		int maxCount = Integer.MIN_VALUE;
		String word = "";
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (maxCount < entry.getValue()) {
				maxCount = entry.getValue();
				word = entry.getKey();
			}
		}

		return word;
	}

	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		
		String mostCommonWord = mostCommonWord(paragraph, banned);
		
		System.out.println(mostCommonWord);
	}

}
