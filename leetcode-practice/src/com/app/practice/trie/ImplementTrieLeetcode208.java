package com.app.practice.trie;

class Trie {
	TrieNode node;

	/** Initialize your data structure here. */
	public Trie() {
		node = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode current = node;
		for (int i = 0; i < word.length(); i++) {
			int indx = word.charAt(i) - 'a';
			if (current.children[indx] == null) {
				current.children[indx] = new TrieNode();
			}
			current = current.children[indx];
		}
		current.isEnd = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode current = node;
		for (int i = 0; i < word.length(); i++) {
			int indx = word.charAt(i) - 'a';
			if (current.children[indx] == null)
				return false;
			current = current.children[indx];
		}
		return current.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode current = node;
		for (int i = 0; i < prefix.length(); i++) {
			int indx = prefix.charAt(i) - 'a';
			if (current.children[indx] == null)
				return false;
			current = current.children[indx];
		}
		return true;
	}
}

public class ImplementTrieLeetcode208 {

	public static void main(String[] args) {
		Trie obj = new Trie();
		obj.insert("apple");
		System.out.println(obj.search("apple"));
		System.out.println(obj.search("app"));
		System.out.println(obj.startsWith("app"));
		obj.insert("app");
		System.out.println(obj.search("app"));

	}

}
