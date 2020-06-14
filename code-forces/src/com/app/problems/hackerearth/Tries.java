package com.app.problems.hackerearth;

import java.util.Scanner;

public class Tries {
	private static final String ADD = "add";
	private static final String FIND = "find";
	
	private static void insert(TrieNode root, String key) {
		TrieNode curr = root;
		for(int i = 0; i < key.length(); i++) {
			int indx = key.charAt(i) - 'a';
			if(curr.children[indx] == null) {
				curr.children[indx] = new TrieNode();
				curr.children[indx].weight = 1;
			} else {
				curr.children[indx].weight++;
			}
			curr = curr.children[indx];
		}
	}
	
	private static int query(TrieNode root, String key) {
		TrieNode curr = root;
		int count = 0;
		for(int i = 0; i < key.length(); i++) {
			int indx = key.charAt(i) - 'a';
			if(curr.children[indx] == null)
				return 0;
			else {
				count = curr.children[indx].weight;
			}
			curr = curr.children[indx];
		}
		return count;
	}
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nOps = scanner.nextInt();
		
		TrieNode root = new TrieNode();
		
		while(nOps-- > 0) {
			String operation = scanner.next();
			String key = scanner.next();
			if(operation.equals(ADD)) {
				insert(root, key);
			} else if(operation.equals(FIND)){
				int count = query(root, key);
				System.out.println(count);
			}
		}

		scanner.close();
	}

}
