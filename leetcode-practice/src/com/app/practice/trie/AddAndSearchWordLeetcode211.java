package com.app.practice.trie;

//class TrieNode {
//	boolean isEnd;
//	TrieNode[] children;
//
//	public TrieNode() {
//		children = new TrieNode[26];
//	}
//}

class WordDictionary {
	TrieNode node;

	/** Initialize your data structure here. */
	public WordDictionary() {
		node = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		int n = word.length();
		TrieNode curr = node;
		for (int i = 0; i < n; i++) {
			int indx = word.charAt(i) - 'a';
			if (curr.children[indx] == null) {
				curr.children[indx] = new TrieNode();
			}
			curr = curr.children[indx];
		}
		curr.isEnd = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		TrieNode curr = node;
		return search(curr, 0, word);
	}
	
	private boolean search(TrieNode curr, int indx, String word) {
		if(curr == null)
			return false;
		if(curr.isEnd) {
			if(indx == word.length())
				return true;
		}
		
		if(indx == word.length()) {
			return false;
		}
		
		if(word.charAt(indx) == '.') {
			for(int i = 0; i < 26; i++) {
				if(curr.children[i] != null) {
					if(search(curr.children[i], indx + 1, word))
						return true;
				}
			}	
		} else {
			int currentIndx = word.charAt(indx) - 'a';
			if(search(curr.children[currentIndx], indx + 1, word))
				return true;
		}
		return false;
	}
}

public class AddAndSearchWordLeetcode211 {

	public static void main(String[] args) {
		WordDictionary wordDict = new WordDictionary();
		wordDict.addWord("bad");
		wordDict.addWord("dad");
		wordDict.addWord("mad");
		
		System.out.println(wordDict.search("pad"));

	}

}
