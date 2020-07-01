package com.app.mock.google.onsite.set1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class StringExpansion {
	private static String[] expand(String S) {
		if(S.indexOf('{') == -1) {
			return new String[] {S};
		}
		int n = S.length();
		Stack<Character> stack = new Stack<>();
		List<List<String>> res = new ArrayList<>();
		List<String> list = null;
		List<String> txt = null;
		
		for(int i = 0; i < n; i++) {
			if(S.charAt(i) == '}') {
				list = new ArrayList<>();
				while(!stack.isEmpty() && stack.peek() != '{') {
					char item = stack.pop();
					list.add(0, item + "");
				}
				stack.pop();
				
				
				if(!stack.isEmpty()) {
					txt = new ArrayList<>();
					while(!stack.isEmpty()) {
						txt.add(0, stack.pop() + "");
					}
					//res.add(list);
				}
				
				if(txt != null && !txt.isEmpty()) {
					res.add(txt);
				}
				
				if(list != null && !list.isEmpty()) {
					res.add(list);
				}
				
			} else {
				char ch = S.charAt(i);
				if(ch != ',') {
					stack.push(ch);
				}
			}
		}
		
		if(!stack.isEmpty()) {
			txt = new ArrayList<>();
			while(!stack.isEmpty()) {
				txt.add(0, stack.pop() + "");
			}
			res.add(txt);
		}
		
		System.out.println(res);
		
		Queue<String> q = new LinkedList<>();
		q.add("");
		q.add(null);
		
		for(List<String> item: res) {
			while(q.peek() != null) {
				String s = q.poll();
				for(String str: item) {
					q.add(s + str);
				}
			}
			q.poll();
			q.add(null);
		}
		
		int size = q.size() - 1;
		String[] output = new String[size];
		int i = 0;
		while(q.peek() != null) {
			output[i++] = q.poll();
		}
		Arrays.sort(output);
		return output;
	}

	public static void main(String[] args) {
		String s = "{a,b}c{d,e}f";
		System.out.println(Arrays.toString(expand(s)));
		
		s = "{a,b,c}d{e,f}";
		
		System.out.println(Arrays.toString(expand(s)));
		
		s = "abcd";
		
		System.out.println(Arrays.toString(expand(s)));
		
		s = "{a,c,d}{b,e,f}";
		
		System.out.println(Arrays.toString(expand(s)));
		
		
	}

}
