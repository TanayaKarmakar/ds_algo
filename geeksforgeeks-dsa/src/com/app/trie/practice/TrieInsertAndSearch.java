package com.app.trie.practice;

import java.util.Scanner;

import com.app.trie.classroom.TrieNode;

public class TrieInsertAndSearch {
	private static void insert(TrieNode root, String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			int indx = word.charAt(i) - 'a';
			if (curr.child[indx] == null) {
				curr.child[indx] = new TrieNode();
			}
			curr = curr.child[indx];
		}
		curr.isEnd = true;
	}

	private static TrieNode insertItems(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			insert(root, word);
		}
		return root;
	}

	private static int search(TrieNode root, String key) {
		TrieNode curr = root;
		for (int i = 0; i < key.length(); i++) {
			int indx = key.charAt(i) - 'a';
			if (curr.child[indx] == null)
				return 0;
			curr = curr.child[indx];
		}
		return curr.isEnd == true ? 1: 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int nTestCases = scanner.nextInt();
		while (nTestCases > 0) {
			int nSize = scanner.nextInt();
			String[] words = new String[nSize];
			for (int i = 0; i < nSize; i++) {
				words[i] = scanner.next();
			}
			TrieNode root = insertItems(words);
			String searchKey = scanner.next();
			int found = search(root, searchKey);
			System.out.println(found);
			nTestCases--;
		}

		scanner.close();
	}

}
