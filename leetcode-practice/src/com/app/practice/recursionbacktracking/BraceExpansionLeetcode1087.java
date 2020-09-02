package com.app.practice.recursionbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BraceExpansionLeetcode1087 {
	private static String[] expand(String S) {
		if (S.indexOf('{') == -1)
			return new String[] { S };

		Stack<Character> stack = new Stack<>();
		List<String> list = new ArrayList<>();
		List<String> txt = new ArrayList<>();
		List<List<String>> res = new ArrayList<>();

		int n = S.length();
		for (int i = 0; i < n; i++) {
			if (S.charAt(i) == '}') {
				list = new ArrayList<>();
				while (!stack.isEmpty() && stack.peek() != '{') {
					list.add(0, stack.pop() + "");
				}
				stack.pop();

				if (!stack.isEmpty()) {
					txt = new ArrayList<>();
					while (!stack.isEmpty()) {
						txt.add(0, stack.pop() + "");
					}
				}

				if(txt != null && !txt.isEmpty())
					res.add(txt);
				
				if(list != null && !list.isEmpty())
					res.add(list);

			} else {
				if (S.charAt(i) != ',') {
					stack.push(S.charAt(i));
				}
			}
		}
		
		if(!stack.isEmpty()) {
			txt = new ArrayList<>();
			while(!stack.isEmpty()) {
				txt.add(0, stack.pop() + "");
			}
		}
		res.add(txt);

		Queue<String> q = new LinkedList<>();
		q.add("");
		q.add(null);

		for (List<String> item : res) {
			while (q.peek() != null) {
				String s = q.poll();
				for (String str : item) {
					q.add(s + str);
				}
			}
			q.poll();
			q.add(null);
		}

		int size = q.size() - 1;
		String[] output = new String[size];
		int i = 0;
		while (q.peek() != null) {
			output[i++] = q.poll();
		}

		Arrays.sort(output);
		return output;
	}

	public static void main(String[] args) {
		String s = "{a,b}c{d,e}f";
		
		String[] output = expand(s);
		
		System.out.println(Arrays.toString(output));

	}

}
