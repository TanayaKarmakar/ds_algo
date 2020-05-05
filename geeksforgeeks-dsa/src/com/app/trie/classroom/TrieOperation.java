package com.app.trie.classroom;

public class TrieOperation {
	private static void insert(String key, TrieNode root) {
		TrieNode curr = root;
		for (int i = 0; i < key.length(); i++) {
			char ch = key.charAt(i);
			int indx = ch - 'a';
			if (curr.child[indx] == null) {
				curr.child[indx] = new TrieNode();
				curr.isEnd = false;
			}
			curr = curr.child[indx];
		}
		curr.isEnd = true;
	}

	private static TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			insert(word, root);
		}
		return root;
	}
	
	private static boolean search(TrieNode root, String key) {
		TrieNode curr = root;
		for(int i = 0; i < key.length(); i++) {
			int indx = key.charAt(i) - 'a';
			if(curr.child[indx] == null)
				return false;
			curr = curr.child[indx];
		}
		return true;
	}
	
	private static TrieNode delete(TrieNode root, String key, int currentIndx) {
		if(root == null)
			return null;
		if(currentIndx == key.length()) {
			root.isEnd = false;
			if(isEmpty(root)) {
				root = null;
			}
			return root;
		}
		
		int indx = key.charAt(currentIndx) - 'a';
		
		root.child[indx] = delete(root.child[indx], key, currentIndx + 1);
		
		if(isEmpty(root) && root.isEnd == false) {
			root = null;
		}
		return root;
 	}
	
	private static boolean isEmpty(TrieNode root) {
		for(int i = 0; i < 26; i++) {
			if(root.child[i] != null)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words = { "bat", "cat", "but", "cut", "kitten", "dog", "kite" };
		TrieNode root = buildTrie(words);
		
		System.out.println(search(root, "bat"));
		System.out.println(search(root, "kitten"));
		System.out.println(search(root, "cate"));
		
		root = delete(root, "kitten", 0);
		
		System.out.println(search(root, "kitten"));
		
	}

}
