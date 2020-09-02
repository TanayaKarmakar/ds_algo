package com.app.practice.graphbfsdfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionaryLeetcode269 {
	private static String alienOrder(String[] words) {
		int n = words.length;
		Map<Character, List<Character>> map = new HashMap<>();
		Map<Character, Integer> inDeg = new HashMap<>();

		for (int i = 0; i < n; i++) {
			char[] arr = words[i].toCharArray();

			for (int j = 0; j < arr.length; j++) {
				map.put(arr[j], new ArrayList<>());
				inDeg.put(arr[j], 0);
			}
		}

		for (int i = 0; i < n - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];

			if (word1.length() > word2.length() && word1.startsWith(word2))
				return "";
			for (int j = 0; j < Integer.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {

					map.get(word1.charAt(j)).add(word2.charAt(j));

					inDeg.put(word2.charAt(j), inDeg.get(word2.charAt(j)) + 1);
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		Queue<Character> q = new LinkedList<>();

		for (Map.Entry<Character, Integer> entry : inDeg.entrySet()) {
			if (entry.getValue() == 0)
				q.add(entry.getKey());
		}

		while (!q.isEmpty()) {
			char ch = q.poll();
			sb.append(ch);

			List<Character> values = map.get(ch);

			for (char ch1 : values) {
				inDeg.put(ch1, inDeg.get(ch1) - 1);
				if (inDeg.get(ch1) == 0) {
					q.add(ch1);
				}
			}

		}

		return inDeg.size() == sb.toString().length() ? sb.toString() : "";
	}

	public static void main(String[] args) {
		String[] words = {"abc", "ab"};
		
		String ans = alienOrder(words);
		
		System.out.println(ans);
	
		
		words = new String[] { "wrt", "wrf", "er", "ett", "rftt" };

		ans = alienOrder(words);

		System.out.println(ans);

		words = new String[] { "z", "x" };

		ans = alienOrder(words);

		System.out.println(ans);

		words = new String[] { "z", "x", "z" };

		ans = alienOrder(words);

		System.out.println(ans);

		words = new String[] { "z", "z" };

		ans = alienOrder(words);

		System.out.println(ans);
	}

}
