package com.app.practice.recursionbacktracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesisLeetcode22 {
	private static Set<String> generateParenthesisRec(int num) {
		if(num == 0) {
			Set<String> res = new HashSet<>();
			res.add("");
			return res;
		}
		Set<String> smallOutput = generateParenthesisRec(num - 1);
		Set<String> newOutput = new HashSet<>();
		for(String str: smallOutput) {
			for(int i = 0; i < str.length(); i++) {
				String newStr = insert(str, i);
				if(newOutput.isEmpty() || !newOutput.contains(newStr))
					newOutput.add(newStr);
			}
			if(!newOutput.contains(str + "()")) {
				newOutput.add(str + "()");
			}
		}
		
		return newOutput;
	}
	
	private static List<String> generateParenthesis(int n) {
		Set<String> res = generateParenthesisRec(n);
		return new ArrayList<>(res);
	}
	
	private static String insert(String str, int left) {
		return str.substring(0, left) + "()" + str.substring(left);
	}

	public static void main(String[] args) {
		List<String> output = generateParenthesis(3);
		
		System.out.println(output);

	}

}
