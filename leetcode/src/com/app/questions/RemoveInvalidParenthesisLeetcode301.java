package com.app.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParenthesisLeetcode301 {
	private static boolean isValid(String s) {
		int count = 0;
		int n = s.length();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(')
				count++;
			if(s.charAt(i) == ')') {
				count--;
				if(count < 0)
					return false;
			}
		}
		
		return count == 0;
	}
	
	private static List<String> removeInvalidParentheses(String s) {
       List<String> res = new ArrayList<>();
       Queue<String> q = new LinkedList<>();
       Set<String> visited = new HashSet<>();
       
       q.add(s);
       
       while(!q.isEmpty()) {
    	   String curr = q.poll();
    	   if(visited.contains(curr))
    		   continue;
    	   visited.add(curr);
    	   if(isValid(curr))
    		   res.add(curr);
    	   if(res.size() != 0)
    		   continue;
    	   for(int i = 0; i < curr.length(); i++) {
    		   if(curr.charAt(i) == ')' || curr.charAt(i) == '(') {
    			   String temp = curr.substring(0, i) + curr.substring(i + 1);
    			   q.add(temp);
    		   }
    	   }
       }
       
       return res;
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
