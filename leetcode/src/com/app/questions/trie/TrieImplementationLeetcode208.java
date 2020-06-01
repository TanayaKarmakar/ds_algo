package com.app.questions.trie;

class TrieNode {
	boolean isEnd;
	TrieNode[] children;
	
	public TrieNode() {
		children = new TrieNode[26];
	}
}

class Trie {
	TrieNode node;
	
    /** Initialize your data structure here. */
    public Trie() {
        node = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int n = word.length();
        TrieNode curr = node;
        
        for(int i = 0; i < n; i++) {
        	int indx = word.charAt(i) - 'a';
        	if(curr.children[indx] == null) {
        		curr.children[indx] = new TrieNode();
        	}
        	curr = curr.children[indx];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int n = word.length();
        TrieNode curr = node;
        for(int i = 0; i < n; i++) {
        	int indx = word.charAt(i) - 'a';
        	if(curr.children[indx] == null)
        		return false;
        	curr = curr.children[indx];
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode curr = node;
        for(int i = 0; i < n; i++) {
        	int indx = prefix.charAt(i) - 'a';
        	if(curr.children[indx] == null)
        		return false;
        	curr = curr.children[indx];
        }
        return true;
    }
}

public class TrieImplementationLeetcode208 {

	public static void main(String[] args) {
		Trie obj = new Trie();
		obj.insert("apple");
		System.out.println(obj.search("apple"));
		System.out.println(obj.startsWith("app"));
		System.out.println(obj.search("app"));
		obj.insert("app");
		System.out.println(obj.search("app"));
		
	}

}
