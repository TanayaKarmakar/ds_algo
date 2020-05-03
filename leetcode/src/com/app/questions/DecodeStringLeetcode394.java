package com.app.questions;

import java.util.Iterator;
import java.util.Stack;

public class DecodeStringLeetcode394 {
	private static String decodeString(String str) {
		Stack<Integer> numStack = new Stack<>();
		Stack<String> charStack = new Stack<>();
		
		int n = str.length();
		for(int i = 0; i < n; ) {
			if(Character.isDigit(str.charAt(i))) {
				int num = 0;
				while(Character.isDigit(str.charAt(i))) {
					num = num * 10 + (str.charAt(i) - '0');
					i++;
				}
				numStack.push(num);
			} else {
				if(str.charAt(i) == ']') {
					StringBuilder sb = new StringBuilder();
					while(!charStack.peek().equals("[")) {
						//sb.append(charStack.pop());
						sb.insert(0, charStack.pop());
					}
					charStack.pop();
					int num = numStack.pop();
					String str1 = sb.toString();
					sb = new StringBuilder();
					int j = 1;
					while(j <= num) {
						sb.append(str1);
						j++;
					}
					charStack.push(sb.toString());
				} else {
					charStack.push(str.charAt(i) + "");
				}
				i++;
			}	
		}
		StringBuilder sb = new StringBuilder();
		Iterator<String> stackItr = charStack.iterator();
		while(stackItr.hasNext()) {
			sb.append(stackItr.next());
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
		
		System.out.println(decodeString(str));
		/*String str = "3[a]2[bc]";
		
		System.out.println(decodeString(str));
		
		str = "3[a2[c]]";
		
		System.out.println(decodeString(str));
		
		str = "2[abc]3[cd]ef";
		
		System.out.println(decodeString(str));*/

	}

}
