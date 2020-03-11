package com.app.questions;

import java.util.Stack;

public class AddBinary {
	private static String addBinary(String a, String b) {
		if(a == null || Integer.parseInt(a) == 0)
			return b;
		if(b == null || Integer.parseInt(b) == 0)
			return a;
		int n = a.length();
		int m = b.length();
		
		Stack<Character> stack = new Stack<>();
		int i = n - 1;
		int j = m - 1;
		int carry = 0;
		while(i >= 0 && j >= 0) {
			char ch1 = a.charAt(i);
			char ch2 = b.charAt(j);
			
			if(ch1 == '0' && ch2 == '0') {
				if(carry == 1) {
					stack.push('1');
					carry = 0;
				} else {
					stack.push('0');
				}
			} else if(ch1 == '1' && ch2 == '1') {
				if(carry == 1) {
					stack.push('1');
				} else {
					stack.push('0');
				}
				carry = 1;
			} else if(ch1 == '1' || ch2 == '1') {
				if(carry == 1) {
					stack.push('0');
					carry = 1;
				} else {
					stack.push('1');
				}
			}
			
			i--;
			j--;
		}
		while(i >= 0) {
			char ch1 = a.charAt(i);
			if(ch1 == '0') {
				if(carry == 1) {
					stack.push('1');
					carry = 0;
				} else {
					stack.push('0');
				}
			} if(ch1 == '1') {
				if(carry == 1) {
					stack.push('0');
					carry = 1;
				} else {
					stack.push('1');
				}
			}
			i--;
		}
		
		while(j >= 0) {
			char ch2 = b.charAt(j);
			if(ch2 == '0') {
				if(carry == 1) {
					stack.push('1');
					carry = 0;
				} else {
					stack.push('0');
				}
			} if(ch2 == '1') {
				if(carry == 1) {
					stack.push('0');
					carry = 1;
				} else {
					stack.push('1');
				}
			}
			j--;
		}
		
		if(carry == 1) {
			stack.push('1');
		}
		
		String str = "";
		while(!stack.isEmpty()) {
			str = str + stack.pop();
		}
		
		return str;
	}

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("1010", "1011"));
	}

}
