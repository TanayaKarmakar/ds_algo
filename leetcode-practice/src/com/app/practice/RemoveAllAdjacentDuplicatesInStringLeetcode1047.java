package com.app.practice;

import java.util.Iterator;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringLeetcode1047 {
	private static String removeDuplicates(String S) {
		int n = S.length();
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			if(stack.isEmpty() || stack.peek() != S.charAt(i))
				stack.push(S.charAt(i));
			else
				stack.pop();
		}
		
		StringBuilder sb = new StringBuilder();
		Iterator<Character> sItr = stack.iterator();
		
		while(sItr.hasNext()) {
			sb.append(sItr.next());
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "abbaca";
		
		System.out.println(removeDuplicates(str));

	}

}
