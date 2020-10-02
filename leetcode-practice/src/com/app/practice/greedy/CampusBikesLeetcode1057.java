package com.app.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CampusBikesLeetcode1057 {
	private static int calcDist(int[] worker, int[] bike) {
		return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
	}

	private static int[] assignBikes(int[][] workers, int[][] bikes) {
		TreeMap<Integer, List<int[]>> distMap = new TreeMap<>();
		for (int i = 0; i < workers.length; i++) {
			for (int j = 0; j < bikes.length; j++) {
				int dist = calcDist(workers[i], bikes[j]);
				if (!distMap.containsKey(dist)) {
					distMap.put(dist, new ArrayList<>());
				}
				distMap.get(dist).add(new int[] { i, j });
			}
		}

		int[] ans = new int[workers.length];
		Arrays.fill(ans, -1);

		Set<Integer> assignedBikes = new HashSet<>();

		for (Map.Entry<Integer, List<int[]>> entry : distMap.entrySet()) {
			List<int[]> values = entry.getValue();
			for (int[] el : values) {
				if (ans[el[0]] == -1 && !assignedBikes.contains(el[1])) {
					ans[el[0]] = el[1];
					assignedBikes.add(el[1]);
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[][] workers = { { 0, 0 }, { 1, 1 }, { 2, 0 } };
		int[][] bikes = { { 1, 0 }, { 2, 2 }, { 2, 1 } };

		int[] ans = assignBikes(workers, bikes);

		System.out.println(Arrays.toString(ans));
	}

}
