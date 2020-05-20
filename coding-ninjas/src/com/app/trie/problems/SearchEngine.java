package com.app.trie.problems;

import java.util.Scanner;

class TrieNode1 {
	int weight;
	TrieNode1[] nodes;
	
	public TrieNode1 () {
		nodes = new TrieNode1[26];
	}
}

public class SearchEngine {
	private static void insert(TrieNode1 head, String txt, int weight) {
		int n = txt.length();
		
		TrieNode1 curr = head;
		for(int i = 0; i < n; i++) {
			int indx = txt.charAt(i) - 'a';
			if(curr.nodes[indx] == null) {
				curr.nodes[indx] = new TrieNode1();
				curr.nodes[indx].weight = weight;
			} else {
				if(curr.nodes[indx].weight < weight) {
					curr.nodes[indx].weight = weight;
				}
			}
			curr = curr.nodes[indx];
		}
	}
	
	private static int getNodeWeight(TrieNode1 head, String str) {
		TrieNode1 curr = head;
		int weight = 0;
		for(int i = 0; i < str.length(); i++) {
			int indx = str.charAt(i) - 'a';
			if(curr.nodes[indx] == null)
				return -1;
			weight = curr.nodes[indx].weight;
			//System.out.println(str.charAt(i) + " " + weight);
			curr = curr.nodes[indx];
		}
		return weight;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		TrieNode1 head = new TrieNode1();
		while(n-- > 0) {
			String text = scanner.next();
			int weight = scanner.nextInt();
			
			insert(head, text, weight);
		}
		
		while(m-- > 0) {
			String str = scanner.next();
			System.out.println(getNodeWeight(head, str));
		}
		scanner.close();
	}

}
