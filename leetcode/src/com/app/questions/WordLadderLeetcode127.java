package com.app.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;

public class WordLadderLeetcode127 {
	private static boolean hasDifferenceOne(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		int count = 0;
		int n = str1.length();
		for (int i = 0; i < n; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				count++;
			}
		}

		return count == 1;
	}

	private static Map<String, List<String>> buildWordGraph(List<String> wordList) {
		int n = wordList.size();
		Map<String, List<String>> graph = new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			String curr = wordList.get(i);
			for (int j = 0; j < n; j++) {
				if (!curr.equals(wordList.get(j)) && hasDifferenceOne(curr, wordList.get(j))) {
					if (!graph.containsKey(curr)) {
						List<String> words = new ArrayList<>();
						words.add(wordList.get(j));
						graph.put(curr, words);
					} else {
						graph.get(curr).add(wordList.get(j));
					}
				}
			}
		}

		return graph;
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		Map<String, List<String>> graph = buildWordGraph(wordList);
		String start = null;
		for (String str : wordList) {
			if (hasDifferenceOne(beginWord, str)) {
				start = str;
				break;
			}
		}

		int count = 0;
		if(!wordList.contains(beginWord))
			count = 1;
		String curr = start;
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.add(curr);
		while (!q.isEmpty()) {
			String item = q.poll();
			visited.add(item);
			
			System.out.println(item);
			
			if(item.equals(endWord)) {
//				count++;
				break;
			}

			List<String> values = graph.get(item);
			for (String str : values) {
				if(hasDifferenceOne(item, str) && !visited.contains(str)) {
					count++;
					q.add(str);
					break;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> words = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

		int ans = ladderLength(beginWord, endWord, words);

		System.out.println(ans);
		
		beginWord = "a";
		endWord = "c";
		
		words = Arrays.asList("a", "b", "c");
		
		ans = ladderLength(beginWord, endWord, words);
		
		System.out.println(ans);

	}

}
