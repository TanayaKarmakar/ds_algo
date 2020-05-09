package com.app.trie.practice;

import java.util.Scanner;

import com.app.trie.classroom.TrieNode;

public class TrieInsertAndSearch2 {
	private static void insert(TrieNode root, String word) {
		TrieNode curr = root;
		for(int i = 0; i < word.length(); i++) {
			int indx = word.charAt(i) - 'a';
			if(curr.child[indx] == null) {
				curr.child[indx] = new TrieNode();
			}
			curr = curr.child[indx];
		}
		curr.isEnd = true;
	}
	
	private static TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for(String word: words) {
			insert(root, word);
		}
		return root;
	}
	
	private static int query(TrieNode root, String key) {
		TrieNode curr = root;
		for(int i = 0; i < key.length(); i++) {
			int indx = key.charAt(i) - 'a';
			if(curr.child[indx] == null)
				return 0;
			curr = curr.child[indx];
		}
		return curr.isEnd == true ? 1: 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while(nTestCases > 0) {
			int n = scanner.nextInt();
			int nQueries = scanner.nextInt();
			String[] words = new String[n];
			for(int i = 0; i < n; i++) {
				words[i] = scanner.next();
			}
			TrieNode root = buildTrie(words);
			while(nQueries > 0) {
				String qStr = scanner.next();
				// call query function
				int found = query(root, qStr);
				System.out.println(found);
				nQueries--;
			}
			nTestCases--;
		}
		scanner.close();

	}

}
