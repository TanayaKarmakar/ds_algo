package com.app.questions;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class OrderFreq {
	int order;
	int freq;
	
	public OrderFreq(int order, int freq) {
		this.order = order;
		this.freq = freq;
	}
}

public class IsoMorphicString {
	private static boolean isIsomorphic(String s, String t) {
		Map<Character, OrderFreq> sMap = createFreqMap(s);
		Map<Character, OrderFreq> tMap = createFreqMap(t);

		if (sMap.size() != tMap.size())
			return false;

		Iterator<Map.Entry<Character, OrderFreq>> sMapItr = sMap.entrySet().iterator();

		Iterator<Map.Entry<Character, OrderFreq>> tMapItr = tMap.entrySet().iterator();

		while (sMapItr.hasNext() && tMapItr.hasNext()) {
			OrderFreq sFreq = sMapItr.next().getValue();
			OrderFreq tFreq = tMapItr.next().getValue();

			if(sFreq.order != tFreq.order || sFreq.freq != tFreq.freq)
				return false;
		}

		return true;
	}

	private static Map<Character, OrderFreq> createFreqMap(String str) {
		Map<Character, OrderFreq> map = new LinkedHashMap<>();
		int n = str.length();

		for (int i = 0; i < n; i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), new OrderFreq(i, 1));
			} else {
				OrderFreq curr = map.get(str.charAt(i));
				curr.order = i;
				++curr.freq;
				map.put(str.charAt(i), curr);
			}
		}

		return map;
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("abba", "abab"));
	}

}
