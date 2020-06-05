package com.app.questions.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CampusBikesLeetcode1057 {
	private static int[] assignBikes(int[][] workers, int[][] bikes) {
		TreeMap<Integer, List<int[]>> map = new TreeMap<>();
		for (int i = 0; i < workers.length; i++) {
			for (int j = 0; j < bikes.length; j++) {
				int dist = Math.abs(workers[i][0] - bikes[j][0]) 
						+ Math.abs(workers[i][1] - bikes[j][1]);
				if (!map.containsKey(dist)) {
					List<int[]> list = new ArrayList<>();
					list.add(new int[] { i, j });
					map.put(dist, list);
				} else {
					map.get(dist).add(new int[] { i, j });
				}
			}
		}
		
		int[] res = new int[workers.length];
		Set<Integer> assignedBikes = new HashSet<>();
		Arrays.fill(res, -1);
		
		for(Map.Entry<Integer, List<int[]>> entry: map.entrySet()) {
			for(int[] arr: entry.getValue()) {
				if(res[arr[0]] == -1 && !assignedBikes.contains(arr[1])) {
					res[arr[0]] = arr[1];
					assignedBikes.add(arr[1]);
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		int[][] bikes = { { 1, 2 }, { 3, 3 } };
		int[][] workers = { { 0, 0 }, { 2, 1 } };

		int[] res = assignBikes(workers, bikes);

		System.out.println(Arrays.toString(res));

		bikes = new int[][] { { 1, 0 }, { 2, 2 }, { 2, 1 } };
		workers = new int[][] { { 0, 0 }, { 1, 1 }, { 2, 0 } };

		res = assignBikes(workers, bikes);

		System.out.println(Arrays.toString(res));

	}

}
