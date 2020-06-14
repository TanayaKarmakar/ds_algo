package com.app.problems.hackerearth;

import java.util.Scanner;

class TrieNode {
	int weight;
	TrieNode[] children;
	
	public TrieNode() {
		children = new TrieNode[26];
	}
}

public class SearchEngine {
	
	private static TrieNode insert(TrieNode root, String word, int weight) {
		TrieNode curr = root;
		
		for(int i = 0; i < word.length(); i++) {
			int indx = word.charAt(i) - 'a';
			if(curr.children[indx] == null) {
				curr.children[indx] = new TrieNode();
				curr.children[indx].weight = weight;
			} else {
				curr.children[indx].weight = Integer.max(curr.children[indx].weight, 
						weight); 
			}
			curr = curr.children[indx];
		}
		
		return root;
	}
	
	private static int getWeight(TrieNode root, String key) {
		TrieNode curr = root;
		int score = 0;
		for(int i = 0; i < key.length(); i++) {
			int indx = key.charAt(i) - 'a';
			if(curr.children[indx] == null)
				return -1;
			curr = curr.children[indx];
			score = curr.weight;
		}
		return score;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int q = scanner.nextInt();
		TrieNode root = new TrieNode();
		
		while(n-- > 0) {
			String key = scanner.next();
			int weight = scanner.nextInt();
			root = insert(root, key, weight);
		}

		while(q-- > 0) {
			String queryStr = scanner.next();
			int weight = getWeight(root, queryStr);
			System.out.println(weight);
			
		}
		scanner.close();
	}

}
