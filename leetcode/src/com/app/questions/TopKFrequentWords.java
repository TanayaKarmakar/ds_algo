package com.app.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class WordFreq implements Comparable<WordFreq> {
	String word;
	int freq;

	public WordFreq(String word, int freq) {
		this.word = word;
		this.freq = freq;
	}

	@Override
	public int compareTo(WordFreq wordFreq) {
		if (this.freq == wordFreq.freq)
			return this.word.compareTo(wordFreq.word);
		else if (this.freq < wordFreq.freq)
			return 1;
		else
			return -1;
	}

}

public class TopKFrequentWords {
	private static List<String> topKFrequentWords(String[] words, int k) {
		Map<String, Integer> freqWord = new HashMap<>();

		for (String word : words) {
			if (!freqWord.containsKey(word)) {
				freqWord.put(word, 1);
			} else {
				int tmp = freqWord.get(word);
				freqWord.put(word, ++tmp);
			}
		}

		PriorityQueue<WordFreq> pQ = new PriorityQueue<>();
		for (Map.Entry<String, Integer> entry : freqWord.entrySet()) {
			pQ.add(new WordFreq(entry.getKey(), entry.getValue()));
		}

		int i = k;
		List<String> res = new ArrayList<>();
		while (i > 0) {
			res.add(pQ.poll().word);
			i--;
		}
		return res;
	}

	public static void main(String[] args) {
		String[] str = { "i", "love", "leetcode", "i", "love", "coding" };

		List<String> res = topKFrequentWords(str, 2);
		System.out.println(res);

		str = new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		
		res = topKFrequentWords(str, 4);
		System.out.println(res);
	}

}
