package com.app.questions.trie;

class WordDictionary {
	TrieNode node;

    /** Initialize your data structure here. */
    public WordDictionary() {
        node = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int n = word.length();
        TrieNode curr = node;
        if(search(word, 0, curr))
        	return;
        
        for(int i = 0; i < n; i++) {
        	char ch = word.charAt(i);
        	if(curr.children[ch - 'a'] == null) {
        		curr.children[ch - 'a'] = new TrieNode();
        	}
        	curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	TrieNode curr = node;
        return search(word, 0, curr);
    }
    
    private boolean search(String word, int indx, TrieNode curr) {
    	if(curr == null)
    		return false;
    	if(curr.isEnd) {
    		if(indx == word.length())
    			return true;
    	}
    	if(indx == word.length())
    		return false;
    	
    	if(word.charAt(indx) == '.') {
    		for(int i = 0; i < 26; i++) {
    			if(curr.children[i] != null) {
    				if(search(word, indx + 1, curr.children[i]) == true)
    					return true;
    			}
    		}
    	} else {
    		int i = word.charAt(indx) - 'a';
    		boolean present = search(word, indx + 1, curr.children[i]);
    		if(present)
    			return true;
    	}
    	return false;
    }
}

public class AddAndSearchWordLeetcode211 {

	public static void main(String[] args) {
		WordDictionary wordDict = new WordDictionary();
		wordDict.addWord("a");
		wordDict.addWord("ab");
		System.out.println(wordDict.search("a"));
		System.out.println(wordDict.search("a."));
		System.out.println(wordDict.search("ab"));
		System.out.println(wordDict.search(".a"));
		System.out.println(wordDict.search("a."));
//		wordDict.addWord("a");
//		wordDict.addWord("a");
//		
//		System.out.println(wordDict.search("."));
//		System.out.println(wordDict.search("a"));
//		System.out.println(wordDict.search("aa"));
//		System.out.println(wordDict.search("a"));
//		System.out.println(wordDict.search(".a"));
//		System.out.println(wordDict.search("a."));
//		wordDict.addWord("bad");
//		wordDict.addWord("dad");
//		wordDict.addWord("mad");
//		
//		System.out.println(wordDict.search("pad"));
//		System.out.println(wordDict.search("bad"));
//		System.out.println(wordDict.search(".ad"));
//		System.out.println(wordDict.search("b.."));

	}

}
