package com.app.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class CharFreq implements Comparable<CharFreq> {
	char ch;
	int freq;

	public CharFreq(char ch, int freq) {
		this.ch = ch;
		this.freq = freq;
	}

	@Override
	public int compareTo(CharFreq that) {
		if (this.freq < that.freq)
			return 1;
		else if (this.freq > that.freq)
			return -1;
		else
			return 0;
	}

}

public class FrequencySort {
	private static String frequencySort(String s) {
		Map<Character, Integer> freq = new HashMap<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (!freq.containsKey(s.charAt(i))) {
				freq.put(s.charAt(i), 1);
			} else {
				int tmp = freq.get(s.charAt(i));
				freq.put(s.charAt(i), ++tmp);
			}
		}

		PriorityQueue<CharFreq> pQ = new PriorityQueue<>();
		for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
			pQ.add(new CharFreq(entry.getKey(), entry.getValue()));
		}

		StringBuilder sb = new StringBuilder();
		while (!pQ.isEmpty()) {
			CharFreq curr = pQ.poll();
			int tmp = curr.freq;
			while(tmp != 0) {
				sb.append(curr.ch);
				tmp--;
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "tree";
		
		System.out.println(frequencySort(str));
		
		str = "cccaaa";
		
		System.out.println(frequencySort(str));
		
		str = "Aabb";
		
		System.out.println(frequencySort(str));
	}

}
