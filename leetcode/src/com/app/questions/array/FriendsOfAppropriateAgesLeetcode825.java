package com.app.questions.array;

import java.util.HashMap;
import java.util.Map;

public class FriendsOfAppropriateAgesLeetcode825 {
	private static boolean canBeFriends(int a, int b) {
		return !((b <= (0.5 * a + 7)) || b > a );
	}

	private static int numFriendRequests(int[] ages) {
		int n = ages.length;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			map.put(ages[i], map.getOrDefault(ages[i], 0) + 1);
		}
		
		int totalCount = 0;
		for(Map.Entry<Integer, Integer> entry1: map.entrySet()) {
			for(Map.Entry<Integer, Integer> entry2: map.entrySet()) {
				if(canBeFriends(entry1.getKey(), entry2.getKey())) {
					totalCount += (entry1.getValue() * entry2.getValue());
					
					if(entry1.getKey() == entry2.getKey()) {
						totalCount -= entry1.getValue();
					}
				}
			}
		}
		
		
		return totalCount;
	}

	public static void main(String[] args) {
		int[] ages = { 16, 16 };
		
		System.out.println(numFriendRequests(ages));
	}

}
