package com.app.practice.stack;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class BackspaceStringCompareLeetcode844 {
	private static String getFinalString(String str) {
		int n = str.length();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == '#') {
				if (!stack.isEmpty())
					stack.pop();
			} else {
				stack.push(str.charAt(i));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Iterator<Character> sItr = stack.iterator();
		while(sItr.hasNext()) {
			sb.append(sItr.next() + "");
		}
		
		return sb.toString();
	}

	private static boolean backspaceCompare(String S, String T) {
		String sFinalString = getFinalString(S);
		String tFinalString = getFinalString(T);
		
		System.out.println(sFinalString);
		System.out.println(tFinalString);
		
		return sFinalString.equals(tFinalString);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String sText = scanner.nextLine();
		String tText = scanner.nextLine();
		
		System.out.println(backspaceCompare(sText, tText));
		
		scanner.close();
	}

}
