package com.app.mock.google.onsite.set1;

import java.util.Iterator;
import java.util.Stack;

public class RemoveDuplicates {
	private static String removeDuplicates(String S) {
		if(S.length() < 2)
			return S;
		Stack<Character> stack = new Stack<>();
		int n = S.length();
		
		for(int i = 0; i < n; i++) {
			if(stack.isEmpty() || S.charAt(i) != stack.peek()) {
				stack.push(S.charAt(i));
			} else {
				stack.pop();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Iterator<Character> sItr = stack.iterator();
		while(sItr.hasNext()) {
			sb.append(sItr.next() + "");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "abbaca";
		
		System.out.println(removeDuplicates(s));

	}

}
