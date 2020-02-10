package com.app.heap.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

class CharFreq implements Comparable<CharFreq> {
	char word;
	int freq;

	public CharFreq(char word, int freq) {
		this.word = word;
		this.freq = freq;
	}

	@Override
	public int compareTo(CharFreq o) {
		if (this.freq == o.freq)
			return 0;
		else if (this.freq < o.freq)
			return 1;
		else
			return -1;
	}

}

public class RearrangeCharacters {
	private static boolean rearrangeChars(String s) {
		Map<Character, Integer> charMap = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!charMap.containsKey(s.charAt(i))) {
				charMap.put(s.charAt(i), 1);
			} else {
				int tmp = charMap.get(s.charAt(i));
				charMap.put(s.charAt(i), ++tmp);
			}
		}

		PriorityQueue<CharFreq> pQ = new PriorityQueue<>();
		for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
			if(entry.getValue() > s.length() / 2)
				return false;
			pQ.add(new CharFreq(entry.getKey(), entry.getValue()));
		}
		
		
		StringBuilder sb = new StringBuilder();
		while(!pQ.isEmpty()) {
			CharFreq cf = pQ.poll();
			CharFreq secondCf = null;
			if(!pQ.isEmpty()) {
				secondCf = pQ.poll();
			}
			sb.append(cf.word);
			
			if(secondCf !=  null) {
				sb.append(secondCf.word);
				secondCf.freq--;
				if(secondCf.freq > 0) {
					pQ.add(secondCf);
				}
			}
			
			cf.freq--;
			if(cf.freq > 0) {
				pQ.add(cf);
			}
		}
		
		//System.out.println(sb.toString());
		
		if(sb.toString().length() != s.length())
			return false;
		return true;
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		
		System.out.println(rearrangeChars(str));
		
		str = "aaabc";
		
		System.out.println(rearrangeChars(str));
		
		str = "bbbb";
		
		System.out.println(rearrangeChars(str));
		
		str = "bbbabaaacd";
		
		System.out.println(rearrangeChars(str));
	}

}
