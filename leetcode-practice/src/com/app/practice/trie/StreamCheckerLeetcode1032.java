package com.app.practice.trie;

class StreamChecker {
	TrieNode trie;
	StringBuilder sb;
	
	public StreamChecker(String[] words) {
		trie = new TrieNode();
		sb = new StringBuilder();
		buildTrie(trie, words);
	}
	
	public boolean query(char ch) {
		sb.append(ch);
		return isPresent();
	}
	
	private boolean isPresent() {
		TrieNode curr = trie;
		for(int i = sb.length() - 1; i >= 0; i--) {
			char c = sb.charAt(i);
			if(curr.children[c - 'a'] == null)
				return false;
			if(curr.children[c - 'a'].isEnd)
				return true;
			curr = curr.children[c - 'a'];
		}
		return false;
	}
	
	private void buildTrie(TrieNode node, String[] words) {
		for(String word: words) {
			TrieNode curr = node;
			for(int i = word.length() - 1; i >= 0; i--) {
				char c = word.charAt(i);
				if(curr.children[c - 'a'] == null) {
					curr.children[c - 'a'] = new TrieNode();
				}
				curr = curr.children[c - 'a'];
			}
			curr.isEnd = true;
		}
	}
}

public class StreamCheckerLeetcode1032 {

	public static void main(String[] args) {
		StreamChecker sc 
		= new StreamChecker(new String[] {"cd", "f", "kl"});
		
		System.out.println(sc.query('a'));
		System.out.println(sc.query('b'));
		System.out.println(sc.query('c'));
		System.out.println(sc.query('d'));
		
		System.out.println(sc.query('e'));
		System.out.println(sc.query('f'));
		
		System.out.println(sc.query('g'));
		System.out.println(sc.query('h'));
		System.out.println(sc.query('i'));
		System.out.println(sc.query('j'));
		System.out.println(sc.query('k'));
		System.out.println(sc.query('l'));
		

	}

}
