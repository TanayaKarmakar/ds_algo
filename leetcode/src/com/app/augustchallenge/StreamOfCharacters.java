package com.app.augustchallenge;

class TrieNode {
	boolean isEnd;
	TrieNode[] children;

	public TrieNode() {
		this.children = new TrieNode[26];
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
		return isPresent(sb.toString());
	}

	private boolean isPresent(String str) {
		TrieNode curr = node;
		for(int i = str.length() - 1; i >= 0; i--) {
			int indx = str.charAt(i) - 'a';
			if(curr.children[indx] == null)
				return false;
			if(curr.children[indx].isEnd)
				return true;
			curr = curr.children[indx];
		}
		return false;
	}

	private void buildTrie(String[] words) {
		for (String word : words) {
			insert(word);
		}
	}

	private void insert(String word) {
		TrieNode curr = node;
		for (int i = word.length() - 1; i >= 0; i--) {
			int indx = word.charAt(i) - 'a';
			if (curr.children[indx] == null)
				curr.children[indx] = new TrieNode();
			curr = curr.children[indx];
		}
		curr.isEnd = true;
	}
}

public class StreamOfCharacters {

	public static void main(String[] args) {
		String[] words = { "cd", "f", "kl" };
		StreamChecker checker = new StreamChecker(words);
		
		System.out.println(checker.query('a'));
		System.out.println(checker.query('b'));
		System.out.println(checker.query('c'));
		System.out.println(checker.query('d'));
		System.out.println(checker.query('e'));
		System.out.println(checker.query('f'));
		System.out.println(checker.query('g'));
		System.out.println(checker.query('h'));
		System.out.println(checker.query('i'));
		System.out.println(checker.query('j'));
		System.out.println(checker.query('k'));
		System.out.println(checker.query('l'));

	}

}
