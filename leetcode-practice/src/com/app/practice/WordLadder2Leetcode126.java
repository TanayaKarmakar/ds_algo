package com.app.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2Leetcode126 {
	private static List<String> populateList(String beginWord, String endWord, Map<String, String> map,
			Set<String> visited) {
		List<String> item = new ArrayList<>();
		String node = endWord;
		while(!node.equals(beginWord)) {
			if(map.get(node) == null)
				break;
			item.add(0, node);
			node = map.get(node);
		}
		
		if(node != endWord) {
			item.add(0, beginWord);
		}
		return item;
	}
	
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
	
	private static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord))
			return new ArrayList<>();
		List<List<String>> res = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		
		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		
		while(!q.isEmpty()) {
			String curr = q.poll();
			if(curr.equals(endWord)) {
				res.add(populateList(beginWord, endWord, map, visited));
			}
			
			for(String word: wordList) {
				if(!visited.contains(word) && diff(word, curr) == 1) {
					map.put(word, curr);
					q.add(word);
					visited.add(word);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String	endWord = "cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		
		System.out.println(findLadders(beginWord, endWord, wordList));

	}

}
