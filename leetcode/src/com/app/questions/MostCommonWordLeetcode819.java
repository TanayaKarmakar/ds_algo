package com.app.questions;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWordLeetcode819 {
	private static String mostCommonWord(String paragraph, String[] banned) {
		if (paragraph.isEmpty())
			return "";
		paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " ");
		String[] words = paragraph.split("\\s+");
		Map<String, Integer> map = new HashMap<>();

		for (String word : words) {
			word = word.toLowerCase();
			// word = word.replaceAll("[^a-zA-Z0-9]", "");
			if (!map.containsKey(word)) {
				map.put(word, 1);
			} else {
				int tmp = map.get(word);
				map.put(word, ++tmp);
			}
		}
		// System.out.println(map);

		for (String bWord : banned) {
			map.remove(bWord);
		}

		int count = Integer.MIN_VALUE;
		String res = "";
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			if (count < value) {
				res = entry.getKey();
				count = value;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		/*
		 * System.out.println( mostCommonWord("Bob hit a ball, the hit BALL flew far
		 * after it was hit.", new String[] { "hit" }));
		 */

		System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[] { "a" }));
	}

}
