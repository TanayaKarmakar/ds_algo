package com.app.practice.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class CharItem implements Comparable<CharItem> {
	char ch;
	int freq;
	
	public CharItem(char ch, int freq) {
		this.ch = ch;
		this.freq = freq;
	}

	@Override
	public int compareTo(CharItem o) {
		return o.freq - this.freq;
	}	
}

public class ReorganizeStringLeetcode767 {
	private static String reorganizeString(String S) {
		Map<Character, Integer> map = new HashMap<>();
		int n = S.length();
		
		int maxFreq = 0;
		for(int i = 0; i < n; i++) {
			map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
			maxFreq = Integer.max(maxFreq, map.get(S.charAt(i)));
		}
		
		int remainingFreq = n - maxFreq;
		if(maxFreq > remainingFreq + 1)
			return "";
		
		PriorityQueue<CharItem> pQ = new PriorityQueue<>();
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			CharItem item = new CharItem(entry.getKey(), entry.getValue());
			pQ.add(item);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pQ.isEmpty()) {
			CharItem item = pQ.poll();
			
			if(!sb.toString().isEmpty() && sb.charAt(sb.length() - 1) == item.ch) {
				if(pQ.isEmpty())
					return "";
				CharItem item1 = pQ.poll();
				sb.append(item1.ch);
				item1.freq--;
				if(item1.freq > 0) {
					pQ.add(item1);
				}
				pQ.add(item);
				continue;
			}
			sb.append(item.ch);
			item.freq--;
			if(item.freq > 0)
				pQ.add(item);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "aab";
		
		System.out.println(reorganizeString(str));

	}

}
