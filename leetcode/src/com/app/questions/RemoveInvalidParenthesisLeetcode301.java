package com.app.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParenthesisLeetcode301 {
	private static boolean isValid(String str) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ')') {
				if(stack.isEmpty())
					return false;
				else
					stack.pop();
			} else if(str.charAt(i) == '('){
				stack.push(str.charAt(i));
			}
		}
		if(stack.isEmpty())
			return true;
		return false;
	}
	
	private static List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        q.add(null);
        
        int maxLen = 0;
        
        while(q.size() > 1) {
        	String str = q.poll();
        	if(str == null) {
        		if(!res.isEmpty())
        			break;
        		q.add(null);
        		continue;
        	}
        	if(isValid(str) && !str.isEmpty()) {
        		res.add(str);
        		maxLen = Integer.max(maxLen, str.length());
        	} else {
        		for(int i = 0; i < str.length(); i++) {
            		if(str.charAt(i) == '(' || str.charAt(i) == ')') {
            			String temp = "";
            			if(i == 0) {
            				temp = str.substring(1);
            			} else if(i == str.length() - 1) {
            				temp = str.substring(0, str.length() - 1);
            			} else {
            				temp = str.substring(0, i) + str.substring(i + 1);
            			}
            			q.add(temp);
            		}
            	}
        	}	
        }
        
        if(res.isEmpty()) {
        	res.add("");
        }
        return new ArrayList<>(res);
    }

	public static void main(String[] args) {
		String str = "()())()";
		
		List<String> res = removeInvalidParentheses(str);
		
		System.out.println(res);
		
		str = "(a)())()";
		
		res = removeInvalidParentheses(str);
		
		System.out.println(res);
		
		str = ")(";
		
		res = removeInvalidParentheses(str);
		
		System.out.println(res);
		
		str = "";
		
		res = removeInvalidParentheses(str);
		
		System.out.println(res);

	}

}
