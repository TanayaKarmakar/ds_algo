package com.app.practice.trie;

import java.util.ArrayList;
import java.util.List;

public class SearchSugeestionsSystemLeetcode1268 {
	private static void insert(TrieNode node, String product) {
		for (int i = 0; i < product.length(); i++) {
			int indx = product.charAt(i) - 'a';
			if (node.children[indx] == null) {
				node.children[indx] = new TrieNode();
			}
			node = node.children[indx];
		}
		node.isEnd = true;
	}

	private static TrieNode buildTrie(String[] products) {
		TrieNode node = new TrieNode();
		for (String product : products) {
			TrieNode curr = node;
			insert(curr, product);
		}
		return node;
	}

	private static void traverseList(TrieNode curr, List<String> item, String word) {
		if (item.size() == 3)
			return;
		if (curr.isEnd)
			item.add(word);

		for (int i = 0; i < 26; i++) {
			if (curr.children[i] != null) {
				String word1 = word + (char) (i + 'a');
				traverseList(curr.children[i], item, word1);
			}
		}
	}

	private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		TrieNode node = buildTrie(products);
		List<List<String>> res = new ArrayList<>();

		for (int i = 0; i < searchWord.length(); i++) {
			String word = searchWord.substring(0, i + 1);
			boolean found = true;

			TrieNode curr = node;
			for (int j = 0; j < word.length(); j++) {
				int indx = word.codePointAt(j) - 'a';
				if (curr.children[indx] == null) {
					found = false;
					break;
				}
				curr = curr.children[indx];
			}

			if (!found) {
				res.add(new ArrayList<>());
			} else {
				List<String> item = new ArrayList<>();
				traverseList(curr, item, word);
				res.add(item);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		String searchWord = "mouse";
		
		List<List<String>> res = suggestedProducts(products, searchWord);
		
		System.out.println(res);
	
	}

}
