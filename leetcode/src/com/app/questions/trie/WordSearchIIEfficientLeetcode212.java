package com.app.questions.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Trie1 {
	boolean isEnd;
	Trie1[] children;

	public Trie1() {
		children = new Trie1[26];
	}
}

public class WordSearchIIEfficientLeetcode212 {
	private static void insert(Trie1 trie, String word) {
		Trie1 curr = trie;
		for (int i = 0; i < word.length(); i++) {
			int indx = word.charAt(i) - 'a';
			if (curr.children[indx] == null) {
				curr.children[indx] = new Trie1();
			}
			curr = curr.children[indx];
		}
		curr.isEnd = true;
	}

	private static Trie1 buildTrie(String[] words) {
		Trie1 node = new Trie1();
		for (String word : words) {
			insert(node, word);
		}
		return node;
	}
	
	private static void dfs(char[][] board, int i, int j, Trie1 node, 
			Set<String> res, String s) {
		char ch = board[i][j];
		if(ch == '$')
			return;
		String ss = s + ch;
		board[i][j] = '$';
		
		Trie1 curr = node.children[ch - 'a'];
		if(curr != null) {
			if(curr.isEnd)
				res.add(ss);
			if(i > 0)
				dfs(board, i - 1, j, curr, res, ss);
			if(j > 0)
				dfs(board, i, j - 1, curr, res, ss);
			if(i < board.length - 1)
				dfs(board, i + 1, j, curr, res, ss);
			if(j < board[0].length - 1)
				dfs(board, i, j + 1, curr, res, ss);
		}
		board[i][j] = ch;
	}

	private static List<String> findWords(char[][] board, String[] words) {
		Trie1 node = buildTrie(words);

		int m = board.length;
		int n = board[0].length;

		Set<String> res = new HashSet<>();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, i, j, node, res, "");
			}
		}
		
		return new ArrayList<>(res);
	}

	public static void main(String[] args) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };

		String[] words = { "oath", "pea", "eat", "rain" };

		List<String> res = findWords(board, words);

		System.out.println(res);
	}

}
