package com.app.questions.read;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Trie {
	boolean isWord;
	Map<Character, Trie> childs;
	
	public Trie() {
		childs = new HashMap<>();
	}
}

public class WordIsTypoBecauseOfStuckKey {
	
	private static Trie createTrie(List<String> dict) {
		Trie root = new Trie();
		for (String word : dict) {
			Trie curr = root;
			for (int i = 0; i < word.length(); i++) {
				if(!curr.childs.containsKey(word.charAt(i))) {
					curr.childs.put(word.charAt(i), new Trie());
				}
				curr = curr.childs.get(word.charAt(i));
			}
			curr.isWord = true;
		}
		return root;
	}
	
	private static boolean match(Trie root, String word, int start) {
		if(root == null)
			return false;
		if(start == word.length())
			return root.isWord;
		if(match(root.childs.get(word.charAt(start)), word, start + 1)) {
			return true;
		} else if(start > 0 && word.charAt(start - 1) == word.charAt(start))
			return match(root, word, start + 1);
		else
			return false;
			
	}

	private static boolean isStuckBecauseOfTypo(List<String> dict, String word) {
		Trie root = createTrie(dict);
		return match(root, word, 0);
	}

	public static void main(String[] args) {
		List<String> dict = Arrays.asList("hello", "cat", "world", "dog", "bird", "grass", "green", "help", "greet",
				"great");
		String key = "helppppp";
		
		System.out.println(isStuckBecauseOfTypo(dict, key));
		
		key = "grass";
		
		System.out.println(isStuckBecauseOfTypo(dict, key));
	}

}
