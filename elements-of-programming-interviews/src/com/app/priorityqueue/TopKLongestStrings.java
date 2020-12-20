package com.app.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKLongestStrings {
	
	private static List<String> topKLongestStrings(List<String> strings, int k) {
		PriorityQueue<String> pQ = new PriorityQueue<>((s1, s2) -> s1.length() - s2.length());
		
		for(String str: strings) {
			pQ.add(str);
			if(pQ.size() > k)
				pQ.poll();
		}
		
		return new ArrayList<>(pQ);
	}

	public static void main(String[] args) {
		List<String> strs = new ArrayList<>(List.of("Java", "C", "Python", ".NET", "C++", "Kotlin", "Scala"));
		
		int k = 3;
		List<String> result = topKLongestStrings(strs, k);
		
		System.out.println(result);

	}

}
