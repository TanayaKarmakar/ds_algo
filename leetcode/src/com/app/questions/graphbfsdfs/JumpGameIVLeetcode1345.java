package com.app.questions.graphbfsdfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class JumpGameIVLeetcode1345 {
	private static int minJumps(int[] arr) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				List<Integer> indices = new ArrayList<>();
				indices.add(i);
				map.put(arr[i], indices);
			} else {
				map.get(arr[i]).add(i);
			}
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		Set<Integer> visited = new HashSet<>();
		int steps = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int indx = q.poll();
				visited.add(indx);

				if (indx == arr.length - 1)
					return steps;

				if (indx - 1 > 0 && !visited.contains(indx - 1)) {
					q.add(indx - 1);
				}
				if (indx + 1 < arr.length && !visited.contains(indx + 1)) {
					q.add(indx + 1);
				}

				if (map.containsKey(arr[indx])) {
					for (int indx1 : map.get(arr[indx])) {
						if (!visited.contains(indx1))
							q.add(indx1);
					}
					map.remove(arr[indx]);
				}
			}
			steps++;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 100, -23, -23, 404, 100, 23, 23, 23, 3, 404 };
		System.out.println(minJumps(nums));

		nums = new int[] { 7 };

		System.out.println(minJumps(nums));

		nums = new int[] { 7, 6, 9, 6, 9, 6, 9, 7 };

		System.out.println(minJumps(nums));

		nums = new int[] { 11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13 };

		System.out.println(minJumps(nums));
	}

}
