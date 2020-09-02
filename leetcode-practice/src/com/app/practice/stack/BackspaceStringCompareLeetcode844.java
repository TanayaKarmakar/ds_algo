package com.app.practice.stack;

import java.util.Stack;

public class BackspaceStringCompareLeetcode844 {
	private static boolean backspaceStringCompare(String S, String T) {
		Stack<Character> sStack = new Stack<>();
		Stack<Character> tStack = new Stack<>();
		
		int n = S.length();
		for(int i = 0; i < n; i++) {
			if(S.charAt(i) == '#') {
				if(!sStack.isEmpty())
					sStack.pop();
			} else {
				sStack.push(S.charAt(i));
			}
		}
		
		int m = T.length();
		for(int i = 0; i < m; i++) {
			if(T.charAt(i) == '#') {
				if(!tStack.isEmpty()) {
					tStack.pop();
				}
			} else {
				tStack.push(T.charAt(i));
			}
		}
		
		while(!sStack.isEmpty() && !tStack.isEmpty()) {
			if(sStack.pop() != tStack.pop())
				return false;
		}
		
		return (sStack.isEmpty() && tStack.isEmpty());
	}

	public static void main(String[] args) {
		

	}

}
