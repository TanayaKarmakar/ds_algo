package com.app.problems.hackerearth;

import java.util.Stack;

public class WildcardCharacters {
	
	private static boolean isMatch(String str, String pattern) {
		Stack<String> patternStack = new Stack<>();
		for(int i = 0; i < pattern.length();) {
			if(pattern.charAt(i) == '}') {
				i++;
			}
			else if(pattern.charAt(i) != '{' && pattern.charAt(i) != '}') {
				patternStack.push(pattern.charAt(i)+"");
				i++;
			} else {
				int num = 0;
				i = i + 1;
				while(i < pattern.length() && pattern.charAt(i) != '}') {
					num = num * 10 + (pattern.charAt(i) - '0');
					i++;
				}
				patternStack.push(num + "");
			}
		}
		
		int m = str.length();
		int i = 0;
		for(i = m - 1; i >= 0 && !patternStack.isEmpty();) {
			String curr = patternStack.pop();
			if(curr.equals("+"))
				i--;
			else if(curr.equals("*")) {
				i = i - 3;
			} else {
				int num = Integer.parseInt(curr);
				if(patternStack.isEmpty())
					return false;
				String next = patternStack.pop();
				i = i - num;
				if(i < 0)
					return false;
			}
		}
		return (i + 1) == 0;
	}

	public static void main(String[] args) {
		String pattern = "+++++*";
		String str = "abcdemmmmmm";
		
		System.out.println(isMatch(str, pattern));
		
		pattern = "**+*{2}";
		str = "mmmrrrkbb";
		
		System.out.println(isMatch(str, pattern));

	}

}
