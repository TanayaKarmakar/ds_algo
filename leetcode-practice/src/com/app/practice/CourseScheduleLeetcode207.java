package com.app.practice;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleLeetcode207 {
	private static boolean canFinish(int numCourses, int[][] prerequisites) {
		LinkedList<Integer>[] edges = new LinkedList[numCourses];
		int[] inDeg = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			edges[i] = new LinkedList<>();
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int[] edge = prerequisites[i];
			edges[edge[1]].add(edge[0]);
			inDeg[edge[0]]++;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDeg[i] == 0) {
				q.add(i);
			}
		}

		int count = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			count++;
			LinkedList<Integer> nodes = edges[node];
			for (Integer el : nodes) {
				inDeg[el]--;
				if (inDeg[el] == 0)
					q.add(el);
			}
		}

		return count == numCourses;
	}

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] preReq = { { 0, 1 } };

		System.out.println(canFinish(numCourses, preReq));

		preReq = new int[][] { { 1, 0 }, { 0, 1 } };
		
		System.out.println(canFinish(numCourses, preReq));

	}

}
