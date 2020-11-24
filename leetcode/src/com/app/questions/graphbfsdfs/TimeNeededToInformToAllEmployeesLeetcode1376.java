package com.app.questions.graphbfsdfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TimeNeededToInformToAllEmployeesLeetcode1376 {
	private static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (manager[i] == -1)
				continue;
			if (!map.containsKey(manager[i]))
				map.put(manager[i], new ArrayList<>());
			map.get(manager[i]).add(i);
		}

		Queue<int[]> q = new LinkedList<>();
		int maxTime = 0;

		q.add(new int[] { headID, 0 });

		while (!q.isEmpty()) {
			int[] node = q.poll();

			List<Integer> nei = map.getOrDefault(node[0], new ArrayList<>());
			for (Integer el : nei) {
				int currentTime = node[1] + informTime[node[0]];
				q.add(new int[] { el, currentTime });
				maxTime = Integer.max(maxTime, currentTime);
			}
		}

		return maxTime;
	}

	public static void main(String[] args) {
		int headID = 0;
		int n = 15;
		int[] manager = { -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 };
		int[] informTime = { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
		
		int ans = numOfMinutes(n, headID, manager, informTime);
		
		System.out.println(ans);
		
		

	}

}
