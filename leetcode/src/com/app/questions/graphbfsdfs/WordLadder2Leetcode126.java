package com.app.questions.graphbfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder2Leetcode126 {
	private static boolean isVisited(String word, List<String> path) {
		for(String el: path) {
			if(el.equals(word))
				return true;
		}
		return false;
	}
	
	private static int diff(String s1, String s2) {
		if(s1.length() != s2.length())
			return (int)Math.abs(s1.length() - s2.length());
		int n = s1.length();
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(s1.charAt(i) != s2.charAt(i))
				count++;
		}
		return count;
	}
	
	private static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		if(!wordList.contains(endWord))
			return res;
		List<String> path = new ArrayList<>();
		path.add(beginWord);
		Map<String, Integer> distMap = new HashMap<>();
		for(String word: wordList) {
			distMap.put(word, Integer.MAX_VALUE);
		}
		distMap.put(beginWord, Integer.MAX_VALUE);
		
		Queue<List<String>> q = new LinkedList<>();
		q.add(path);
		while(!q.isEmpty()) {
			path = q.poll();
			String last = path.get(path.size() - 1);
			if(last.equals(endWord)) {
				res.add(path);
			}
			
			List<String> temp = new ArrayList<>();
			for(String word: wordList) {
				if(!isVisited(word, path) && diff(last, word) == 1
						&& distMap.get(last) + 1 <= distMap.get(word)) {
					List<String> newPath = new ArrayList<>(path);
					newPath.add(word);
					q.add(newPath);
					distMap.put(word, distMap.get(last) + 1);
					temp.add(word);
				}
			}
			//wordList.removeAll(temp);
		}
		return res;
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
		//Arrays.asList("hot","dot","dog","lot","log","cog");
		
		
		List<List<String>> res = findLadders(beginWord, endWord, wordList);
		
		System.out.println(res);

	}

}
