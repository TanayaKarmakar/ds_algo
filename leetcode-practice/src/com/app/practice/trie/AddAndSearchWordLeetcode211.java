package com.app.practice.trie;

class WordDictionary {
	TrieNode node;
	
	public WordDictionary() {
		node = new TrieNode();
	}
	
	public void addWord(String word) {
		if(search(word))
			return;
		TrieNode curr = node;
		for(int i = 0; i < word.length(); i++) {
			int indx = word.charAt(i) - 'a';
			if(curr.children[indx] == null) {
				curr.children[indx] = new TrieNode();
			}
			curr = curr.children[indx];
		}
		curr.isEnd = true;
	}

	public boolean search(String word) {
		TrieNode curr = node;
		if(search(word, 0, curr))
			return true;
		return false;
	}
	
	private boolean search(String word, int indx, TrieNode curr) {
		if(curr == null)
			return false;
		if(curr.isEnd) {
			if(indx == word.length())
				return true;
		}
		if(indx == word.length())
			return false;
		
		char ch = word.charAt(indx);
		if(ch == '.') {
			for(int i = 0; i < 26; i++) {
				if(curr.children[i] != null) {
					boolean isPresent = search(word, indx + 1, curr.children[i]);
					if(isPresent)
						return true;
				}
			}
			
		} else {
			int i = word.charAt(indx) - 'a';
			boolean isPresent = search(word, indx + 1, curr.children[i]);
			if(isPresent)
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
		System.out.println(wordDict.search("bad"));
		System.out.println(wordDict.search(".ad"));
		System.out.println(wordDict.search("b.."));
	}

}
