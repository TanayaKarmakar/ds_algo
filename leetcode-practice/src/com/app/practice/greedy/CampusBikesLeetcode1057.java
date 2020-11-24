package com.app.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CampusBikesLeetcode1057 {
	private static int dist(int[] pt1, int[] pt2) {
		return Math.abs(pt1[0] - pt2[0]) + Math.abs(pt1[1] - pt2[1]);
	}

	private static int[] assignBikes(int[][] workers, int[][] bikes) {
		TreeMap<Integer, List<int[]>> distMap = new TreeMap<>();
		for (int i = 0; i < workers.length; i++) {
			for (int j = 0; j < bikes.length; j++) {
				int d = dist(workers[i], bikes[j]);
				if (!distMap.containsKey(d)) {
					distMap.put(d, new ArrayList<>());
				}
				distMap.get(d).add(new int[] { i, j });
			}
		}

		Set<Integer> assignedBikes = new HashSet<>();
		int n = workers.length;
		int[] res = new int[n];
		Arrays.fill(res, -1);

		for (Map.Entry<Integer, List<int[]>> entry : distMap.entrySet()) {
			List<int[]> values = entry.getValue();

			for (int[] val : values) {
				int v1 = val[0];
				int v2 = val[1];
				if (res[v1] == -1 && !assignedBikes.contains(v2)) {
					res[v1] = v2;
					assignedBikes.add(v2);
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] workers = { { 0, 0 }, { 2, 1 } };
		int[][] bikes = { { 1, 2 }, { 3, 3 } };
		
		int[] res = assignBikes(workers, bikes);
		
		System.out.println(Arrays.toString(res));

	}

}
