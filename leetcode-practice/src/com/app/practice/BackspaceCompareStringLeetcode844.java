package com.app.practice;

import java.util.Stack;

public class BackspaceCompareStringLeetcode844 {
	private static Stack<Character> getBackSpaceCompare(String s) {
		Stack<Character> stack = new Stack<>();
		
		int n = s.length();
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == '#') {
				if(!stack.isEmpty())
					stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}
		
		return stack;
	}
	
	private static boolean backspaceCompare(String S, String T) {
		Stack<Character> stack1 = getBackSpaceCompare(S);
		Stack<Character> stack2 = getBackSpaceCompare(T);
		
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			if(stack1.pop() != stack2.pop())
				return false;
		}
		if(!stack1.isEmpty() || !stack2.isEmpty())
			return false;
		return true;
	}

	public static void main(String[] args) {
		String str1 = "ab#c";
		String str2 = "ad#c";
		
		System.out.println(backspaceCompare(str1, str2));
		
		str1 = "ab##";
		str2 = "c#d#";
		
		System.out.println(backspaceCompare(str1, str2));

		str1 = "a##c";
		str2 = "#a#c";
		
		System.out.println(backspaceCompare(str1, str2));
		
		str1 = "a#c";
		str2 = "b";
		
		System.out.println(backspaceCompare(str1, str2));
	}

}
