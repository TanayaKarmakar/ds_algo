package com.app.questions.read;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenerateParenthesis2 {
	private static List<String> generateParenthesisRec(int remaining) {
		if(remaining == 0) {
			List<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		List<String> res = generateParenthesisRec(remaining - 1);
		List<String> newOutput = new ArrayList<>();
		for(String str: res) {
			int n = str.length();
			for(int i = 0; i < n; i++) {
				if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
					newOutput.add(insert(str, i, "()"));
					newOutput.add(insert(str, i, "{}"));
					newOutput.add(insert(str, i, "[]"));
				}
			}
			newOutput.add("()" + str);
			newOutput.add("{}" + str);
			newOutput.add("[]" + str);
		}
		return newOutput;
	}
	
	private static List<String> generateParenthesis(int remaining) {
		List<String> ans = generateParenthesisRec(remaining);
		return new ArrayList<>(new HashSet<>(ans));
	}
	
	private static String insert(String str, int indx, String target) {
		String ans = str.substring(0, indx + 1) + target + str.substring(indx + 1);
		return ans;
	}

	public static void main(String[] args) {
		List<String> res = generateParenthesis(3);
		
		System.out.println(res);
		
		System.out.println(res.size());

	}

}
