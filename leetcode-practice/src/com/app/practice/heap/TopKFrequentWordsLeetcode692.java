package com.app.practice.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class WordItem implements Comparable<WordItem> {
	String word;
	int freq;

	public WordItem(String word, int freq) {
		this.word = word;
		this.freq = freq;
	}

	@Override
	public int compareTo(WordItem o) {
		if(this.freq  - o.freq == 0)
			return this.word.compareTo(o.word);
		return this.freq - o.freq;
	}
}

public class TopKFrequentWordsLeetcode692 {
	private static List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> freqMap = new HashMap<>();
		
		for (String word : words) {
			freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
		}
		
		PriorityQueue<WordItem> pQ = new PriorityQueue<>();
		for(Map.Entry<String, Integer> entry: freqMap.entrySet()) {
			pQ.add(new WordItem(entry.getKey(), entry.getValue()));
		}
		
		List<String> res = new ArrayList<>();
		while(!pQ.isEmpty() && k-- > 0) {
			res.add(pQ.poll().word);
		}
		
		return res;
	}

	public static void main(String[] args) {
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		int k = 2;

		List<String> res = topKFrequent(words, k);

		System.out.println(res);

		words = new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		k = 4;
		
		
		res = topKFrequent(words, k);

		System.out.println(res);
	}

}
