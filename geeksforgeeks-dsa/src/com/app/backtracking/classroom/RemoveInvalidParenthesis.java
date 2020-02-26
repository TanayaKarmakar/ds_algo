package com.app.backtracking.classroom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParenthesis {
	private static boolean isValid(String str) {
		int open = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				open++;
			else if (str.charAt(i) == ')') {
				if(open == 0) {
					return false;
				}
				open--;
			}
		}

		return (open == 0);
	}

	private static boolean isValidChar(char ch) {
		return (ch == ')' || ch == '(');
	}

	private static List<String> removeInvalidParenthesis(String str) {
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		List<String> res = new ArrayList<>();

		visited.add(str);
		q.add(str);
		boolean found = false;

		while (!found && !q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String s = q.poll();
				if (isValid(s)) {
					found = true;
					res.add(s);
					continue;
				}
				for (int j = 0; j < s.length(); j++) {
					if (!isValidChar(s.charAt(j)))
						continue;
					String temp = s.substring(0, j) + s.substring(j + 1);
					if (!visited.contains(temp)) {
						visited.add(temp);
						q.offer(temp);
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String str = "()())()";

		List<String> res = removeInvalidParenthesis(str);
		System.out.println(res);

		str = ")(";

		res = removeInvalidParenthesis(str);
		System.out.println(res);

		str = "(a)())()";

		res = removeInvalidParenthesis(str);
		System.out.println(res);

	}

}
