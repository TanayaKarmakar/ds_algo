package com.app.questions.graphbfsdfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TimeNeededToInformAllEmployeesLeetcode1376 {
	private static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		int totalTime = 0;

		for (int i = 0; i < n; i++) {
			if (manager[i] == -1)
				continue;
			if (!adjList.containsKey(manager[i]))
				adjList.put(manager[i], new ArrayList<>());
			adjList.get(manager[i]).add(i);
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {headID, informTime[headID]});

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			List<Integer> subordinates = adjList.getOrDefault(curr[0], new ArrayList<>());
			for(Integer subordinate: subordinates) {
				q.add(new int[] {subordinate, curr[1] + informTime[subordinate]});
			}
			totalTime = Integer.max(totalTime, curr[1]);
			
		}

		return totalTime;
	}

	public static void main(String[] args) {
		int n = 1;
		int headID = 0;
		int[] manager = { -1 };
		int[] informTime = { 0 };

		int ans = numOfMinutes(n, headID, manager, informTime);

		System.out.println(ans);
		
		

		n = 11;
		headID = 4;
		manager = new int[] { 5, 9, 6, 10, -1, 8, 9, 1, 9, 3, 4 };
		informTime = new int[] { 0, 213, 0, 253, 686, 170, 975, 0, 261, 309, 337 };

		ans = numOfMinutes(n, headID, manager, informTime);

		System.out.println(ans);
		
		String str = "tanaya";
		
		System.out.println(str.contains("an"));
		
		System.out.println(str.indexOf("an"));
	}

}
