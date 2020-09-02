package com.app.practice.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchIILeetcode212 {
	private static void buildTrie(TrieNode trie, String[] words) {
		for (String word : words) {
			TrieNode curr = trie;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (curr.children[ch - 'a'] == null) {
					curr.children[ch - 'a'] = new TrieNode();
				}
				curr = curr.children[ch - 'a'];
			}
			curr.isEnd = true;
		}
	}

	private static void dfs(char[][] board, int i, int j, TrieNode trie, String s, Set<String> set) {
		if (board[i][j] == '$')
			return;
		char ch = board[i][j];
		board[i][j] = '$';
		String ss = s + ch;

		TrieNode curr = trie.children[ch - 'a'];
		if (curr != null) {
			if (curr.isEnd)
				set.add(ss);
			if (i > 0)
				dfs(board, i - 1, j, curr, ss, set);
			if (j > 0)
				dfs(board, i, j - 1, curr, ss, set);
			if (i < board.length - 1)
				dfs(board, i + 1, j, curr, ss, set);
			if (j < board[0].length - 1)
				dfs(board, i, j + 1, curr, ss, set);
		}
		board[i][j] = ch;
	}

	private static List<String> findWords(char[][] board, String[] words) {
		TrieNode trie = new TrieNode();
		buildTrie(trie, words);

		Set<String> set = new HashSet<>();
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, i, j, trie, "", set);
			}
		}

		return new ArrayList<>(set);
	}

	public static void main(String[] args) {
		String[] words = { "oath", "pea", "eat", "rain" };
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		
		List<String> output = findWords(board, words);
		
		System.out.println(output);

	}

}
