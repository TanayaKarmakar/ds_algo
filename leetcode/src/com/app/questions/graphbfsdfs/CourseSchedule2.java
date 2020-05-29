package com.app.questions.graphbfsdfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
	private static int[] findSchedule(int numCourses, int[][] preReq) {
		LinkedList<Integer>[] adjList = new LinkedList[numCourses];
		for(int i = 0;i<numCourses;i++) {
			adjList[i] = new LinkedList<>();
		}
		int[] inDeg = new int[numCourses];

		for (int i = 0; i < preReq.length; i++) {
			int[] curr = preReq[i];
			int s = curr[1];
			int t = curr[0];
			adjList[s].add(t);
			inDeg[t]++;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDeg[i] == 0) {
				q.add(i);
			}
		}
		
		int[] res = new int[numCourses];
		int count = 0;
		while(!q.isEmpty()) {
			Integer curr = q.poll();
			res[count] = curr;
			count++;
			
			LinkedList<Integer> list = adjList[curr];
			for(Integer el: list) {
				inDeg[el]--;
				if(inDeg[el] == 0)
					q.add(el);
			}
		}
		
		if(count ==  numCourses)
			return res;
		return new int[0];
	}

	public static void main(String[] args) {
		int[][] preReq = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

		int[] res = findSchedule(4, preReq);

		System.out.println(Arrays.toString(res));

		res = findSchedule(5, preReq);

		System.out.println(Arrays.toString(res));

		preReq = new int[][] { { 1, 0 }, { 0, 1 } };

		res = findSchedule(2, preReq);

		System.out.println(Arrays.toString(res));

		res = findSchedule(3, preReq);

		System.out.println(Arrays.toString(res));

		preReq = new int[][] { { 1, 0 } };

		res = findSchedule(3, preReq);

		System.out.println(Arrays.toString(res));

		res = findSchedule(2, preReq);

		System.out.println(Arrays.toString(res));

		preReq = new int[][] {};

		res = findSchedule(2, preReq);

		System.out.println(Arrays.toString(res));

	}

}
