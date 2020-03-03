package com.app.questions;

import java.util.Stack;

//problem statement -  Given a string S of lowercase letters, 
// a duplicate removal consists of choosing two adjacent and 
// equal letters, and removing them.

// We repeatedly make duplicate removals on S until we no longer can.

// Return the final string after all such duplicate removals have been made.  
// It is guaranteed the answer is unique.
public class RemoveDuplicateChars {
	private static String removeDuplicates(String str) {
		Stack<Character> stack = new Stack<>();
		
		int n = str.length();
		for(int i = 0;i<n;i++) {
			if(stack.isEmpty() || stack.peek() != str.charAt(i)) {
				stack.push(str.charAt(i));
			} else {
				stack.pop();
			}
		}
		
		String res = "";
		while(!stack.isEmpty()) {
			res = stack.pop() + res;
		}
		
		return res;
	}

	public static void main(String[] args) {
		String str = "abbaca";
		
		System.out.println(removeDuplicates(str));

	}

}
