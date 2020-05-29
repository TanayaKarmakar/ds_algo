package com.app.questions.graphbfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class CourseFinish {
	private static boolean canSolve(int[][] prerequisites, int numCourses) {
		LinkedList<Integer>[] adjList = new LinkedList[numCourses];

		for (int i = 0; i < numCourses; i++) {
			adjList[i] = new LinkedList<>();
		}

		int[] degree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int[] curr = prerequisites[i];
			int s = curr[1];
			int t = curr[0];
			adjList[s].add(t);
			degree[t]++;
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0) {
				q.add(i);
			}
		}
		
		int count = 0;
		while(!q.isEmpty()) {
			Integer curr = q.poll();
			count++;
			
			for(int i = 0;i<adjList[curr].size();i++) {
				int k = adjList[curr].get(i);
				degree[k]--;
				if(degree[k] == 0)
					q.add(k);
			}
		}
		
		return count == numCourses;
	}

	public static void main(String[] args) {
		int[][] preReq = { { 1, 0 } };

		System.out.println(canSolve(preReq, 2));

		preReq = new int[][] { { 1, 0 }, { 0, 1 } };

		System.out.println(canSolve(preReq, 2));
		
		System.out.println(canSolve(preReq, 3));
		
		preReq = new int[][] { { 1, 0 }};
		
		System.out.println(canSolve(preReq, 3));
	}

}
