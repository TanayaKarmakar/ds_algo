package com.app.questions.read;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLockLeetcode752 {
	private static int openTheLock(String target, String[] deadEnds) {
		Set<String> deadEndSet = new HashSet<>();
		for (String str : deadEnds) {
			deadEndSet.add(str);
		}

		if (deadEndSet.contains("0000"))
			return -1;

		Queue<String> q = new LinkedList<>();
		q.add("0000");
		q.add(null);

		int level = 0;

		while (!q.isEmpty()) {
			String curr = q.poll();
			if (deadEndSet.contains(curr))
				continue;
			if (curr == null) {
				q.add(null);
				level++;
				continue;
			}
			if (curr.equals(target))
				return level;
			for (int i = 0; i < 4; i++) {
				for (int d = -1; d <= 1; d += 2) {
					int y = ((curr.charAt(i) - '0') + d + 10) % 10;
					String temp = curr.substring(0, i) + (y + "") + curr.substring(i + 1);
					q.add(temp);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String str = "0202";
		String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
		int level = openTheLock(str, deadends);
		
		System.out.println(level);
	}

}
