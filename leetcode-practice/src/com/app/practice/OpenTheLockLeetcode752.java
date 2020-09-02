package com.app.practice;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;

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

		int level = 0;
		while (!q.isEmpty()) {
			String move = q.poll();
			if (move == null) {
				level++;
				if(q.peek() != null)
					q.add(null);
				continue;
			}

			if (deadEndSet.contains(move))
				continue;

			if (move.equals(target))
				return level;

			for (int i = 0; i < 4; i++) {
				for (int d = -1; d <= 1; d += 2) {
					int val = move.charAt(i) - '0';
					int y = ((10 + d) + val) % 10;
					String newMove = "";
					if (i == 0) {
						newMove = y + move.substring(1);
					} else if (i == 3) {
						newMove = move.substring(0, i) + y;
					} else {
						newMove = move.substring(0, i) + y + move.substring(i + 1);
					}
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

		int level = openLock(deadEnds, target);

		System.out.println(level);

		deadEnds = new String[] { "8888" };
		target = "0009";

		level = openLock(deadEnds, target);

		System.out.println(level);

		deadEnds = new String[] { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" };
		target = "8888";
		
		level = openLock(deadEnds, target);

		System.out.println(level);
	}

}
