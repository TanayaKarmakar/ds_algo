package com.app.practice.graphbfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleLeetcode207 {
	private static boolean canFinish(int[][] prerequisites, int numCourses) {
		int n = prerequisites.length;
		LinkedList<Integer>[] edges = new LinkedList[numCourses];
		int[] inDeg = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			edges[i] = new LinkedList<>();
		}

		for (int i = 0; i < n; i++) {
			int[] item = prerequisites[i];
			edges[item[1]].add(item[0]);
			inDeg[item[0]]++;
		}

		Queue<Integer> q = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < numCourses; i++) {
			if (inDeg[i] == 0) {
				q.add(i);
			}
		}

		if (q.isEmpty())
			return false;

		while (!q.isEmpty()) {
			int node = q.poll();
			count++;

			LinkedList<Integer> nodes = edges[node];
			for (int el : nodes) {
				inDeg[el]--;
				if (inDeg[el] == 0) {
					q.add(el);
				}
			}
		}

		return count == numCourses;
	}

	public static void main(String[] args) {
		int[][] prerequisites = { { 0, 1 } };

		boolean canFinish = canFinish(prerequisites, 2);

		System.out.println(canFinish);

		prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };
		
		canFinish = canFinish(prerequisites, 2);

		System.out.println(canFinish);

	}

}
