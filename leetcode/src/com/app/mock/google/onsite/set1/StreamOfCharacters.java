package com.app.mock.google.onsite.set1;

class TrieNode {
	TrieNode[] children;
	boolean isEnd;

	public TrieNode() {
		children = new TrieNode[26];
	}
}

class StreamChecker {
	TrieNode node;
	StringBuilder sb;

	public StreamChecker(String[] words) {
		node = new TrieNode();
		sb = new StringBuilder();
		buildTrie(words);
	}

	public boolean query(char letter) {
		sb.append(letter);
		return isPresent();
	}
	
	private boolean isPresent() {
		TrieNode root = node;
		for(int i = sb.length() - 1; i >= 0; i--) {
			char c = sb.charAt(i);
			if(root.children[c - 'a'] == null)
				return false;
			if(root.children[c - 'a'].isEnd)
				return true;
			root = root.children[c - 'a'];
		}
		return false;
	}

	private void buildTrie(String[] words) {	
		for (String word : words) {
			TrieNode curr = node;
			int n = word.length();
			for (int i = n - 1; i >= 0; i--) {
				int indx = word.charAt(i) - 'a';
				if (curr.children[indx] == null) {
					curr.children[indx] = new TrieNode();
				}
				curr = curr.children[indx];
			}
			curr.isEnd = true;
		}
	}

}

public class StreamOfCharacters {

	public static void main(String[] args) {
		
		StreamChecker checker = new StreamChecker(new String[] {"cd","f", "kl"});
		System.out.println(checker.query('a'));
		System.out.println(checker.query('b'));
		System.out.println(checker.query('c'));
		System.out.println(checker.query('d'));
		
		System.out.println(checker.query('e'));
		System.out.println(checker.query('f'));
	}

}
