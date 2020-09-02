package com.app.practice.priorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Item implements Comparable<Item> {
	char ch;
	int freq;
	
	public Item(char ch, int freq) {
		this.ch = ch;
		this.freq = freq;
	}

	@Override
	public int compareTo(Item o) {
		return o.freq - this.freq;
	}	
}

public class SortCharacterBuFrequencyLeetcode451 {
	private static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		PriorityQueue<Item> pQ = new PriorityQueue<>();
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			pQ.add(new Item(entry.getKey(), entry.getValue()));
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pQ.isEmpty()) {
			Item item = pQ.poll();
			for(int i = 0; i < item.freq; i++)
				sb.append(item.ch);
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.next();
		
		String ans = frequencySort(text);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
