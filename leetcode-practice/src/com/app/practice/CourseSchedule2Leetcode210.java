package com.app.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2Leetcode210 {
	private static int[] findOrder(int numCourses, int[][] preReq) {
		int[] inDeg = new int[numCourses];
		int[] res = new int[numCourses];

		LinkedList<Integer>[] edges = new LinkedList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			edges[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < preReq.length; i++) {
			int[] edge = preReq[i];
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
			res[count++] = node;

			LinkedList<Integer> nodes = edges[node];
			for (Integer el : nodes) {
				inDeg[el]--;
				if (inDeg[el] == 0) {
					q.add(el);
				}
			}
		}
		if (count == numCourses)
			return res;
		else
			return new int[] {};
	}

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] preReq = { { 1, 0 } };

		int[] res = findOrder(numCourses, preReq);

		System.out.println(Arrays.toString(res));

		numCourses = 4;
		preReq = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

		res = findOrder(numCourses, preReq);
		
		System.out.println(Arrays.toString(res));
	}

}
