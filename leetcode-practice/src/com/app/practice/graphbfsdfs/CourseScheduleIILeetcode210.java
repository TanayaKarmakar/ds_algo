package com.app.practice.graphbfsdfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleIILeetcode210 {
	private static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] output = new int[numCourses];
		int[] inDeg = new int[numCourses];
		LinkedList<Integer>[] edges = new LinkedList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			edges[i] = new LinkedList<Integer>();
		}

		int e = prerequisites.length;
		for (int i = 0; i < e; i++) {
			int[] edge = prerequisites[i];
			edges[edge[1]].add(edge[0]);
			inDeg[edge[0]]++;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDeg[i] == 0)
				q.add(i);
		}

		int k = 0;
		while (!q.isEmpty()) {
			Integer item = q.poll();
			output[k++] = item;

			LinkedList<Integer> items = edges[item];

			for (Integer el : items) {
				inDeg[el]--;
				if (inDeg[el] == 0)
					q.add(el);
			}
		}

		return output;
	}

	public static void main(String[] args) {
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

		int[] output = findOrder(4, prerequisites);

		System.out.println(Arrays.toString(output));
	}

}
