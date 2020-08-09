package com.app.questions.graphbfsdfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class RemoveInvalidParenthesisLeetcode301 {
	private static boolean isValid(String s) {
		int n = s.length();
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == '(') {
				count++;
			} else if(s.charAt(i) == ')')
				count--;
			if(count < 0)
				return false;
		}
		
		return count == 0;
	}
	
	private static List<String> removeInvalidParentheses(String s) {
		if(isValid(s)) {
			List<String> res = new ArrayList<>();
			res.add(s);
			return res;
		}
		Queue<String> q = new LinkedList<>();
		List<String> res = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		q.add(s);
		visited.add(s);
		
		while(!q.isEmpty()) {
			String curr = q.poll();
			
			if(isValid(curr)) {
				res.add(curr);
			} else if(res.size() > 0) {
				continue;
			}
			
			for(int i = 0; i < curr.length(); i++) {
				String tmp;
				if(curr.charAt(i) == ')' || curr.charAt(i) == '(') {
					if(i == 0) {
						tmp = curr.substring(i + 1);
					} else if(i == curr.length() - 1) {
						tmp = curr.substring(0, curr.length() - 1);
					} else {
						tmp = curr.substring(0, i) + curr.substring(i + 1);
					}
					if(!visited.contains(tmp)) {
						q.add(tmp);
						visited.add(tmp);
					}	
				}
			}
		}
		
		return new ArrayList<>(res);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String txt = scanner.next();
		
		List<String> res = removeInvalidParentheses(txt);
		
		System.out.println(res);
		
		scanner.close();
	}

}
