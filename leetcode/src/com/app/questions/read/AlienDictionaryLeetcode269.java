package com.app.questions.read;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionaryLeetcode269 {
	private static String alienOrder(String[] words) {
		Map<Character, List<Character>> adjList = new HashMap<>();
		Map<Character, Integer> counts = new HashMap<>();

		for (String word : words) {
			for (char ch : word.toCharArray()) {
				adjList.put(ch, new ArrayList<>());
				counts.put(ch, 0);
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];

			if (word1.length() > word2.length() && word1.startsWith(word2))
				return "";
			for (int j = 0; j < Integer.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					adjList.get(word1.charAt(j)).add(word2.charAt(j));
					counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
				}
			}
		}

		Queue<Character> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		for (char ch : counts.keySet()) {
			if (counts.get(ch) == 0) {
				q.add(ch);
			}
		}

		while (!q.isEmpty()) {
			char ch = q.poll();
			sb.append(ch);

			List<Character> nodes = adjList.get(ch);
			for (char ch1 : nodes) {
				counts.put(ch1, counts.get(ch1) - 1);

				if (counts.get(ch1) == 0)
					q.add(ch1);
			}

		}

		if (sb.length() < counts.size())
			return "";

		return sb.toString();
	}

	public static void main(String[] args) {
		String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
		
		String str = alienOrder(words);
		
		System.out.println(str);

	}

}
