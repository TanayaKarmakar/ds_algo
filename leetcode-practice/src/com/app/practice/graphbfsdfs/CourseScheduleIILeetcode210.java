package com.app.practice.graphbfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleIILeetcode210 {
	private static int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		int[] inDeg = new int[numCourses];
		Queue<Integer> q = new LinkedList<>();

		for (int[] preReq : prerequisites) {
			int d = preReq[0];
			int s = preReq[1];

			if (!adjList.containsKey(s))
				adjList.put(s, new ArrayList<>());
			adjList.get(s).add(d);
			inDeg[d]++;
		}
		
		for(int i = 0; i < inDeg.length; i++) {
			if(inDeg[i] == 0)
				q.add(i);
		}
		
		if(q.isEmpty())
			return new int[] {};

		int[] res = new int[numCourses];
		int j = 0;
		while (!q.isEmpty()) {
			Integer el = q.poll();
			res[j++] = el;
			List<Integer> neighbors = adjList.getOrDefault(el, new ArrayList<>());

			for (Integer nei : neighbors) {
				inDeg[nei]--;
				if (inDeg[nei] == 0)
					q.add(nei);
			}
		}

		return j == numCourses? res: new int[] {};
	}

	public static void main(String[] args) {
		int[][] preReq = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		
		int[] res = findOrder(4, preReq);
		
		System.out.println(Arrays.toString(res));

	}

}
