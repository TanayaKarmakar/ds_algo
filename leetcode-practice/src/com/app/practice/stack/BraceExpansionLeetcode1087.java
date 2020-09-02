package com.app.practice.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BraceExpansionLeetcode1087 {
	private static String[] expand(String S) {
		if(S.indexOf('{') == -1) {
			String[] res = new String[1];
			res[0] = S;
			return res;
		}
		int n = S.length();
		
		List<List<String>> res = new ArrayList<>();
		List<String> exprList =null;
		List<String> txtList = null;
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			if(S.charAt(i) == '}') {
				exprList = new ArrayList<>();
				while(!stack.isEmpty() && stack.peek() != '{') {
					exprList.add(0, stack.pop() + "");
				}
				
				stack.pop();
				
				if(!stack.isEmpty()) {
					txtList = new ArrayList<>();
					
					while(!stack.isEmpty()) {
						txtList.add(0, stack.pop() + "");
					}
				}
				
				if(txtList != null && !txtList.isEmpty()) {
					res.add(txtList);
				}
				
				if(exprList != null && !exprList.isEmpty()) {
					res.add(exprList);
				}
			} else {
				if(S.charAt(i) != ',')
					stack.push(S.charAt(i));
			}
		}
		
		if(!stack.isEmpty()) {
			txtList = new ArrayList<>();
			while(!stack.isEmpty()) {
				txtList.add(stack.pop() + "");
			}
			
			res.add(txtList);
		}
		
		Queue<String> q = new LinkedList<>();
		q.add("");
		q.add(null);
		
		for(List<String> item: res) {
			while(q.peek() != null) {
				String str = q.poll();
				for(String el: item) {
					q.add(str + el);
				}
			}
			q.poll();
			q.add(null);
		}
		
		int size = q.size() - 1;
		String[] finalOutput = new String[size];
		int i = 0;
		while(q.peek() != null) {
			finalOutput[i++] = q.poll();
		}
		
		return finalOutput;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.next();
		
		String[] res = expand(txt);
		
		System.out.println(Arrays.toString(res));
		
		scanner.close();
	}

}
