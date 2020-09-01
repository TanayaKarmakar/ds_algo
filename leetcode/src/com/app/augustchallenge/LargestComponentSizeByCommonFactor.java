package com.app.augustchallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestComponentSizeByCommonFactor {
	private static int count = 0;

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	private static void dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int v) {
		visited.add(v);
		count++;
		List<Integer> neighbors = map.get(v);
		for (Integer nei : neighbors) {
			if (!visited.contains(nei))
				dfs(map, visited, nei);
		}
	}

	private static int largestComponentSize(int[] A) {
		Set<Integer> visited = new HashSet<>();
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if(i == j)
					continue;
				int commonFactor = gcd(A[j], A[i]);
				if (!map.containsKey(A[i])) {
					map.put(A[i], new ArrayList<>());
				}

				if (!map.containsKey(A[j])) {
					map.put(A[j], new ArrayList<>());
				}

				if (commonFactor > 1) {
					map.get(A[i]).add(A[j]);
					map.get(A[j]).add(A[i]);
				}
			}
		}

		int maxCount = 0;
		for (int i = 0; i < A.length; i++) {
			if (!visited.contains(A[i])) {
				count = 0;
				dfs(map, visited, A[i]);
				maxCount = Integer.max(maxCount, count);
			}
		}

		return maxCount;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int ans = largestComponentSize(nums);

		System.out.println(ans);

	}

}
