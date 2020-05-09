package com.app.trie.classroom;

public class TrieNode {
	public TrieNode[] child;
	public boolean isEnd;
	public int same = 1;
	public int count;
	
	public TrieNode() {
		child = new TrieNode[26];
		isEnd = false;
	}

}
