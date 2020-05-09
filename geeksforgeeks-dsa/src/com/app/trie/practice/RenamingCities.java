package com.app.trie.practice;

import java.util.Scanner;

import com.app.trie.classroom.TrieNode;

public class RenamingCities {

	private static String insert(TrieNode root, String key) {
		TrieNode curr = root;
		String ans = "";
		String temp = "";
		for(int i = 0; i < key.length(); i++) {
			int indx1 = key.charAt(i) - 'a';
			temp += key.charAt(i);
			if(curr.child[indx1] == null) {
				curr.child[indx1] = new TrieNode();
			}
			int cnt = ++curr.child[indx1].count;
			if(cnt == 1 && ans.equals("")) {
				ans = temp;
			}
			curr = curr.child[indx1];
		}
		if(curr.isEnd) {
			curr.same++;
		}
		if(ans.equals("")) {
			ans = key + ((curr.same > 1) ? " " + curr.same : "");
		}
		curr.isEnd = true;
		return ans;
	}
		
	
	private static void insertAll(String[] words) {
		TrieNode root = new TrieNode();
		for(int i = 0; i < words.length; i++) {
			String stationCode = insert(root, words[i]);
			System.out.println(stationCode);
		}
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while(nTestCases > 0) {
			int n = scanner.nextInt();
			String[] words = new String[n];
			for(int i = 0; i < n; i++) {
				words[i] = scanner.next();
			}
			insertAll(words);
			nTestCases--;
		}
		scanner.close();
	}

}
