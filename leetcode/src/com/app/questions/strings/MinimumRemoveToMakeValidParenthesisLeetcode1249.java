package com.app.questions.strings;

public class MinimumRemoveToMakeValidParenthesisLeetcode1249 {
	private static String minRemoveToMakeValid(String s) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				count--;
				if (count < 0) {
					count++;
					continue;
				}
			} else if (s.charAt(i) == '(')
				count++;
			sb.append(s.charAt(i));
		}

		s = sb.toString();
		sb = new StringBuilder();
		count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				count--;
				if (count < 0) {
					count++;
					continue;
				}

			} else if (s.charAt(i) == ')')
				count++;
			sb.insert(0, s.charAt(i));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";

		System.out.println(minRemoveToMakeValid(s));

		s = "))((";

		System.out.println(minRemoveToMakeValid(s));

//		s = "(a(b(c)d)";
//		
//		System.out.println(minRemoveToMakeValid(s));

	}

}
