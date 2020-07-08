package com.app.questions.trie;

import java.util.ArrayList;
import java.util.List;

class TrieNode1 {
	boolean isEnd;
	TrieNode1[] children;

	public TrieNode1() {
		children = new TrieNode1[26];
	}
}

public class SearchSuggestionSystemLeetcode1268 {
	private static void insert(TrieNode1 trie, String word) {
		TrieNode1 curr = trie;
		for (int i = 0; i < word.length(); i++) {
			int indx = word.charAt(i) - 'a';
			if (curr.children[indx] == null) {
				curr.children[indx] = new TrieNode1();
			}
			curr = curr.children[indx];
		}
		curr.isEnd = true;
	}

	private static TrieNode1 buildTrie(String[] products) {
		TrieNode1 trie = new TrieNode1();
		for (String word : products) {
			insert(trie, word);
		}
		return trie;
	}

	private static void traverseList(TrieNode1 node, String word, List<String> item) {
		if(item.size() == 3)
			return;
		if (node.isEnd) {
			item.add(word);
		}
		for (int i = 0; i < 26; i++) {
			if (node.children[i] != null) {
				String word1 = word + (char) (i + 'a');
				traverseList(node.children[i], word1, item);
			}
		}	
	}

	private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		TrieNode1 node = buildTrie(products);
		List<List<String>> res = new ArrayList<>();
		for (int i = 0; i < searchWord.length(); i++) {
			String str = searchWord.substring(0, i + 1);
			TrieNode1 curr = node;
			boolean found = true;
			for (int j = 0; j < str.length(); j++) {
				int indx = str.charAt(j) - 'a';
				if (curr.children[indx] == null) {
					found = false;
					break;
				}
				curr = curr.children[indx];
			}
			if (!found)
				res.add(new ArrayList<>());
			else {
				List<String> item = new ArrayList<>();
				traverseList(curr, str, item);
				res.add(item);
			}
		}
		return res;
	}

	private static void displayList(List<List<String>> suggestions) {
		for (List<String> suggestion : suggestions) {
			System.out.println(suggestion);
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		String[] words = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };

		String searchWord = "mouse";

		List<List<String>> suggestions = suggestedProducts(words, searchWord);
		
		displayList(suggestions);
		
		words = new String[] { "havana" };

		searchWord = "havana";
		
		suggestions = suggestedProducts(words, searchWord);
		
		displayList(suggestions);
		
		
	}

}
