package com.app.practice.recursionbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BraceExpansionLeetcode1087 {
	private static String[] expand(String S) {
		if(S.indexOf('{') == -1)
			return new String[] {S};
		int n = S.length();
		Stack<String> stack = new Stack<>();
		List<List<String>> finalList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (S.charAt(i) == '}') {
				List<String> exprList = new ArrayList<>();
				while (!stack.peek().equals("{")) {
					exprList.add(0, stack.pop());
				}
				stack.pop();

				if (!stack.isEmpty()) {
					List<String> txt = new ArrayList<>();
					while (!stack.isEmpty()) {
						txt.add(0, stack.pop());
					}
					finalList.add(txt);
				}

				finalList.add(exprList);
			} else {
				if (S.charAt(i) != ',')
					stack.push(S.charAt(i) + "");
			}
		}

		if (!stack.isEmpty()) {
			List<String> text = new ArrayList<>();
			while (!stack.isEmpty()) {
				text.add(0, stack.pop());
			}
			finalList.add(text);
		}

		//System.out.println(finalList);
		
		Queue<String> q = new LinkedList<>();

		
		q.add("");
		q.add(null);
		for(List<String> list: finalList) {
			while(q.peek() != null) {
				String str = q.poll();
				for(String el: list)
					q.add(str + el);

			}
			q.poll();
			q.add(null);
		}
		String[] resultArr = new String[q.size() - 1];
		int k = 0;
		while(q.peek() != null) {
			resultArr[k++] = q.poll();
		}
		Arrays.sort(resultArr);
		
		return resultArr;
	}

	public static void main(String[] args) {
		String str = "{a,b}c{d,e}f";
		String[] resultArr = expand(str);
		
		System.out.println(Arrays.toString(resultArr));

	}

}
