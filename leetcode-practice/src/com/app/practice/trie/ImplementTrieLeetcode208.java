package com.app.practice.trie;

class TrieNode {
	boolean isEnd;
	TrieNode[] children;
	
	public TrieNode() {
		children = new TrieNode[26];
	}
}

class Trie {
	boolean isEnd;
	TrieNode node;
	
	public Trie() {
		node = new TrieNode();
	}
	
	public void insert(String key) {
		TrieNode curr = node;
		for(int i = 0; i < key.length(); i++) {
			int indx = key.charAt(i) - 'a';
			if(curr.children[indx] == null) {
				curr.children[indx] = new TrieNode();
			}
			curr = curr.children[indx];
		}
		curr.isEnd = true;
	}
	
	public boolean search(String key) {
		TrieNode curr = node;
		for(int i = 0; i < key.length(); i++) {
			int indx = key.charAt(i) - 'a';
			if(curr.children[indx] == null)
				return false;
			curr = curr.children[indx];
		}
		return curr.isEnd;
	}
	
	public boolean startsWith(String key) {
		TrieNode curr = node;
		for(int i = 0; i < key.length(); i++) {
			int indx = key.charAt(i) - 'a';
			if(curr.children[indx] == null)
				return false;
			curr = curr.children[indx];
		}
		return true;
	}
}

public class ImplementTrieLeetcode208 {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
		
	}

}
