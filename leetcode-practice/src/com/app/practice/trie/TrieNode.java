package com.app.practice.trie;

public class TrieNode {
	boolean isEnd;
	TrieNode[] children;
	
	public TrieNode() {
		this.children = new TrieNode[26];
	}
}
