package com.app.trie.classroom;

public class TrieNode {
	TrieNode[] child;
	boolean isEnd;
	
	public TrieNode() {
		child = new TrieNode[26];
		isEnd = false;
	}

}
