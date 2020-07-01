package com.app.questions.array;

import java.util.HashMap;
import java.util.Map;

public class DeckOfCardsLeetcode914 {
	private static boolean hasGroupSizeX(int[] deck) {
		int min = Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for(int num: deck) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			min = Integer.min(min, entry.getValue());
		}
		
		if(min < 2)
			return false;
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if(entry.getValue() % min != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
