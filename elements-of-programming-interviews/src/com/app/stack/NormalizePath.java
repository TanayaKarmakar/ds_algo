package com.app.stack;

import java.util.Iterator;
import java.util.Stack;

public class NormalizePath {
	private static String simplifyPath(String str) {
		if (str.isEmpty())
			return "";

		Stack<String> stack = new Stack<>();
		if (str.startsWith("/"))
			stack.push("/");

		String[] strs = str.split("/");

		for (String token : strs) {
			if (token.equals("..")) {
				if (stack.isEmpty() || stack.peek().equals(".."))
					stack.push(token);
				else if (stack.peek().equals("/"))
					break;
			} else if (!token.isEmpty() && !token.equals("."))
				stack.push(token);
		}

		StringBuilder result = new StringBuilder();

		Iterator<String> sItr = stack.iterator();
		String prev = sItr.next();
		result.append(prev);

		while (sItr.hasNext()) {
			if (!prev.equals("/"))
				result.append("/");
			prev = sItr.next();
			result.append(prev);
		}

		return result.toString();
	}

	public static void main(String[] args) {
		String str = "//a///b/c";

		String ans = simplifyPath(str);
		
		System.out.println(ans);

	}

}
