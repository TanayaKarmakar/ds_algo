package com.app.practice.stack;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class DecodeStringLeetcode394 {

	private static String decodeString(String s) {
		Stack<String> charStack = new Stack<>();
		Stack<Integer> numStack = new Stack<>();
		int n = s.length();

		StringBuilder sb;
		for (int i = 0; i < n;) {
			if (Character.isDigit(s.charAt(i))) {
				int num = 0;
				while (Character.isDigit(s.charAt(i))) {
					num = num * 10 + (s.charAt(i) - '0');
					i++;
				}
				numStack.push(num);
			} else {
				if (s.charAt(i) == ']') {
					sb = new StringBuilder();

					while (!charStack.peek().equals("[")) {
						sb.append(charStack.pop());
					}

					charStack.pop();
					String str = sb.reverse().toString();
					sb = new StringBuilder();

					int num = numStack.pop();
					while (num-- > 0) {
						sb.append(str);
					}

					charStack.push(sb.toString());
				} else {
					charStack.push(s.charAt(i) + "");
				}
				i++;
			}
		}

		sb = new StringBuilder();
		Iterator<String> sItr = charStack.iterator();

		while (sItr.hasNext()) {
			sb.append(sItr.next());
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.next();
		String ans = decodeString(txt);

		System.out.println(ans);

		scanner.close();

	}

}
