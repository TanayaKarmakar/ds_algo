package com.app.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CampusBikesLeetcode1057 {
	private static int getDist(int[] e1, int[] e2) {
		return Math.abs(e1[0] - e2[0]) + Math.abs(e1[1] - e2[1]);
	}

	private static int[] assignBikes(int[][] workers, int[][] bikes) {

		TreeMap<Integer, List<int[]>> map = new TreeMap<>();

		for (int i = 0; i < workers.length; i++) {
			for (int j = 0; j < bikes.length; j++) {
				int dist = getDist(workers[i], bikes[j]);
				if (!map.containsKey(dist)) {
					map.put(dist, new ArrayList<>());
				}
				map.get(dist).add(new int[] { i, j });
			}
		}
		
		int[] res = new int[workers.length];
		Arrays.fill(res, -1);
		
		Set<Integer> assignedBikes = new HashSet<>();
		
		for(Map.Entry<Integer, List<int[]>> entry: map.entrySet()) {
			List<int[]> values = entry.getValue();
			
			for(int[] value: values) {
				if(res[value[0]] == -1 && !assignedBikes.contains(value[1])) {
					res[value[0]] = value[1];
					assignedBikes.add(value[1]);
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int[][] workers = new int[n][2];
		
		for(int i = 0; i < workers.length; i++) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			
			int[] val = new int[] {v1, v2};
			workers[i] = val;
		}
		
		int m = scanner.nextInt();
		
		int[][] bikes = new int[m][2];
		
		for(int i = 0; i < bikes.length; i++) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			
			int[] val = new int[] {v1, v2};
			bikes[i] = val;
		}
		
		int[] res = assignBikes(workers, bikes);
		
		System.out.println(Arrays.toString(res));
		
		scanner.close();
	}

}
