package com.app.practice.strings;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class RemoveAllDuplicatesInAStringLeetcode1047 {
	private static String removeDuplicates(String S) {
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
			sb.append(sItr.next());
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String txt = scanner.next();
		
		String ans = removeDuplicates(txt);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
