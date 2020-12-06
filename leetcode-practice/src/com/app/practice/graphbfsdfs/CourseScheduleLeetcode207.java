package com.app.practice.graphbfsdfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleLeetcode207 {
	private static boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		int[] inDeg = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int[] node = prerequisites[i];
			int source = node[1];
			int dest = node[0];
			if (!adjList.containsKey(source)) {
				adjList.put(source, new ArrayList<>());
			}
			adjList.get(source).add(dest);
			inDeg[dest]++;
		}

		Queue<Integer> q = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < inDeg.length; i++) {
			if (inDeg[i] == 0) {
				q.add(i);
				count++;
			}
		}

		while (!q.isEmpty()) {
			Integer node = q.poll();
			List<Integer> nodes = adjList.getOrDefault(node, new ArrayList<>());

			for (Integer n : nodes) {
				inDeg[n]--;
				if (inDeg[n] == 0) {
					q.add(n);
					count++;
				}
			}
		}

		return count == numCourses ? true : false;
	}

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = { { 1, 0 } };

		System.out.println(canFinish(numCourses, prerequisites));

		numCourses = 2;
		prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };
		
		System.out.println(canFinish(numCourses, prerequisites));

	}

}
