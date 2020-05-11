package com.app.questions.read;

import java.util.Stack;

public class NumberFollowingAPatternGooglePhoneRound {
	private static void getMin(String str) {
		Stack<String> stack = new Stack<>();
		int n = str.length();
		
		for(int i = 0; i <= n; i++) {
			stack.push((i + 1) + "");
			if(i == n || str.charAt(i) == 'I') {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {	 
		 getMin("D");
		 getMin("DD");
		 getMin("IIDDD");
		 getMin("DDIDDIID");
	}

}
