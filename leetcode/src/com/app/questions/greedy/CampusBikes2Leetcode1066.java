package com.app.questions.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CampusBikes2Leetcode1066 {
	private static int assignBikes(int[][] workers, int[][] bikes) {
		int n = workers.length;
		int m = bikes.length;

		TreeMap<Integer, List<int[]>> map = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int dist = Math.abs(workers[i][0] - bikes[i][0]) + Math.abs(workers[i][1] - bikes[i][1]);

				if (!map.containsKey(dist)) {
					List<int[]> list = new ArrayList<>();
					list.add(new int[] { i, j });
					map.put(dist, list);
				} else {
					map.get(dist).add(new int[] { i, j });
				}
			}
		}

		int totalDist = 0;
		int[] res = new int[n];
		Arrays.fill(res, -1);
		Set<Integer> assignedBikes = new HashSet<>();
		for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
			for (int[] arr : entry.getValue()) {
				if (res[arr[0]] == -1 && !assignedBikes.contains(arr[1])) {
					res[arr[0]] = arr[1];
					totalDist += entry.getKey();
					assignedBikes.add(arr[1]);
				}
			}
		}

		return totalDist;
	}

	public static void main(String[] args) {
		int[][] workers = { { 0, 0 }, { 2, 1 } };
		int[][] bikes = { { 1, 2 }, { 3, 3 } };

		int totalCost = assignBikes(workers, bikes);

		System.out.println(totalCost);

		workers = new int[][] { { 0, 0 }, { 1, 1 }, { 2, 0 } };
		bikes = new int[][] { { 1, 0 }, { 2, 2 }, { 2, 1 } };
		
		totalCost = assignBikes(workers, bikes);

		System.out.println(totalCost);
	}

}
