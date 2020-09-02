package com.app.practice.graphbfsdfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Parenthesis {
	String str;
	int open;
	int close;

	public Parenthesis(String str, int open, int close) {
		this.str = str;
		this.open = open;
		this.close = close;
	}
	
	public String toString() {
		return this.str;
	}
}

public class GenerateParenthesisLeetcode22 {
	private static List<String> generateParenthesis(int n) {
		Queue<Parenthesis> q = new LinkedList<>();
		q.add(new Parenthesis("", 0, 0));

		List<String> output = new ArrayList<>();
		while (!q.isEmpty()) {
			Parenthesis p = q.poll();

			if (p.open == n && p.close == n) {
				output.add(p.str);
			} else {
				if (p.open < n) {
					q.add(new Parenthesis(p.str + "(", p.open + 1, p.close));
				}
				if (p.open > p.close) {
					q.add(new Parenthesis(p.str + ")", p.open, p.close + 1));
				}
			}
		}
		
		return output;
	}

	public static void main(String[] args) {
		int n = 3;
		List<String> output = generateParenthesis(n);
		
		System.out.println(output);

	}

}
