package com.app.practice.graphbfsdfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderLeetcode127 {
	private static int diff(String str1, String str2) {
		if (str1.length() != str2.length())
			return Math.abs(str1.length() - str2.length());
		int n = str1.length();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (str1.charAt(i) != str2.charAt(i))
				count++;
		}
		return count;
	}

	private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		q.add(null);

		Set<String> visited = new HashSet<>();
		int ladderLength = 1;

		while (!q.isEmpty()) {
			String item = q.poll();
			visited.add(item);
			if (item == null) {
				if (q.peek() != null) {
					q.add(null);
				}
				ladderLength++;
				continue;
			}

			if (item.equals(endWord))
				return ladderLength;

			List<String> itemsToBeDeleted = new ArrayList<>();
			for (String str : wordList) {
				if (diff(str, item) == 1 && !visited.contains(str)) {
					itemsToBeDeleted.add(str);
					q.add(str);
				}

			}
			wordList.removeAll(itemsToBeDeleted);
		}

		return ladderLength;
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";

		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");

		int ladderLength = ladderLength(beginWord, endWord, wordList);

		System.out.println(ladderLength);

	}

}
