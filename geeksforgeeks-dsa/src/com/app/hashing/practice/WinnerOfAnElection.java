package com.app.hashing.practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class KeyValueComparator implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		if(o1.getValue() == o2.getValue())
			return o1.getKey().compareTo(o2.getKey());
		else if(o1.getValue() < o2.getValue())
			return 1;
		else
			return -1;
	}
}

public class WinnerOfAnElection {
	private static void winner(String[] names) {
		Map<String, Integer> candidateMap = new LinkedHashMap<>();
		
		for(String name: names) {
			if(!candidateMap.containsKey(name)) {
				candidateMap.put(name, 1);
			} else {
				int tmp = candidateMap.get(name);
				candidateMap.put(name, ++tmp);
			}
		}
		
		List<Map.Entry<String, Integer>> listOfEntries = new LinkedList<>(candidateMap.entrySet());
		Collections.sort(listOfEntries, new KeyValueComparator());
		
		System.out.println(listOfEntries.get(0).getKey() + " " + listOfEntries.get(0).getValue());
	}

	public static void main(String[] args) {
		String[] names = {"john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", 
				"jamie", "john", "johnny", "jamie", "johnny", "john"};
		
		winner(names);

	}

}
