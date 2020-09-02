package com.app.practice.graphbfsdfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLockLeetcode752 {
	private static int openLock(String[] deadEnds, String target) {
		Set<String> deadEndSet = new HashSet<>();

		for (String deadEnd : deadEnds) {
			deadEndSet.add(deadEnd);
		}

		if (deadEndSet.contains("0000"))
			return -1;
		Queue<String> q = new LinkedList<>();
		q.add("0000");
		q.add(null);
		
		Set<String> visited = new HashSet<>();
		visited.add("0000");

		int count = 0;
		while (!q.isEmpty()) {
			String curr = q.poll();

			if (curr == null) {
				count++;
				if (q.peek() != null)
					q.add(null);
				continue;
			}

			if (deadEndSet.contains(curr))
				continue;

			if (curr.equals(target))
				return count;

			for (int i = 0; i < curr.length(); i++) {
				int val = curr.charAt(i) - '0';
				for (int d = -1; d <= 1; d += 2) {
					int y = ((10 + d) + val) % 10;
					String newMove = curr.substring(0, i) + y + curr.substring(i + 1);
					if(!visited.contains(newMove)) {
						q.add(newMove);
						visited.add(newMove);
					}	
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String[] deadEnds = { "0201", "0101", "0102", "1212", "2002" };
		String target = "0202";

		int count = openLock(deadEnds, target);

		System.out.println(count);

		deadEnds = new String[] { "8888" };
		target = "0009";

		count = openLock(deadEnds, target);

		System.out.println(count);

		deadEnds = new String[] { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" };
		target = "8888";
		
		count = openLock(deadEnds, target);

		System.out.println(count);
	
	}

}
