package com.app.practice.priorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class WordItem implements Comparable<WordItem> {
	char key;
	int freq;
	
	public WordItem(char key, int freq) {
		this.key = key;
		this.freq = freq;
	}

	@Override
	public int compareTo(WordItem o) {
		return o.freq - this.freq;
	}
}

public class SortCharactersByFrequencyLeetcode451 {
	private static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		PriorityQueue<WordItem> pQ = new PriorityQueue<>();
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			pQ.add(new WordItem(entry.getKey(), entry.getValue()));
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pQ.isEmpty()) {
			WordItem wi = pQ.poll();
			
			int freq = wi.freq;
			while(freq > 0) {
				sb.append(wi.key + "");
				freq--;
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "tree";
		
		String ans = frequencySort(str);
		
		System.out.println(ans);

	}

}
