package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;

public class FriendsOfAppropriateAgeLeetcode825 {
	private static boolean canSendReq(int a, int b) {
		return !(b <= (0.5 * a + 7) || b > a);
	}

	private static int numFriendRequests(int[] ages) {
		Map<Integer, Integer> map = new HashMap<>();

		int n = ages.length;

		for (int i = 0; i < n; i++) {
			map.put(ages[i], map.getOrDefault(ages[i], 0) + 1);
		}

		int totalCount = 0;

		for (Map.Entry<Integer, Integer> entry1 : map.entrySet()) {
			for (Map.Entry<Integer, Integer> entry2 : map.entrySet()) {
				if (canSendReq(entry1.getKey(), entry2.getKey())) {
					totalCount += (entry1.getValue() * entry2.getValue());

					if (entry1.getKey() == entry2.getKey())
						totalCount -= entry1.getValue();
				}
			}
		}

		return totalCount;
	}

	public static void main(String[] args) {
		int[] nums = { 16, 17, 18 };
		
		int ans = numFriendRequests(nums);
		
		System.out.println(ans);

	}

}
