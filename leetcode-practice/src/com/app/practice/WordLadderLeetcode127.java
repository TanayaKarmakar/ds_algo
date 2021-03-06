package com.app.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderLeetcode127 {
	private static int diff(String str1, String str2) {
		if(str1.length() != str2.length())
			return Math.abs(str1.length() - str2.length());
		int n = str1.length();
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(str1.charAt(i) != str2.charAt(i))
				count++;
		}
		return count;
	}
	
	private static int ladderLength(List<String> wordList, String beginWord, String endWord) {
		if(!wordList.contains(endWord))
			return 0;
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		List<String> newWordList = new ArrayList<>(wordList);
		q.add(beginWord);
		q.add(null);
		int count = 1;
		
		while(!q.isEmpty()) {
			String curr = q.poll();
			visited.add(curr);
			if(curr == null) {
				count++;
				if(q.peek() != null)
					q.add(null);
				continue;
			}
			if(curr.equals(endWord))
				return count;
			List<String> toBeDeleted = new ArrayList<>();
			for(String str: newWordList) {
				if(diff(curr, str) == 1 && !visited.contains(str)) {
					q.add(str);
					toBeDeleted.add(str);
				}
			}
			newWordList.removeAll(toBeDeleted);
		}
		return 0;
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		int level = ladderLength(wordList, beginWord, endWord);
		System.out.println(level);
		
		wordList = Arrays.asList("hot","dot","dog","lot","log");
		level = ladderLength(wordList, beginWord, endWord);
		System.out.println(level);
		
	}

}
