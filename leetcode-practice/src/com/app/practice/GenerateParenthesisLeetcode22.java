package com.app.practice;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesisLeetcode22 {
	private static List<String> generateParenthesis(int n) {
		if(n == 0) {
			List<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		List<String> output = generateParenthesis(n - 1);
		List<String> newOutput = new ArrayList<>();
		for(String str: output) {
			int k = str.length();
			for(int i = 0; i < k; i++) {
				if(str.charAt(i) == '(') {
					String finalString = insert(str, i);
					newOutput.add(finalString);
				}
			}
			newOutput.add("()" + str);
		}
		return newOutput;
	}
	
	private static String insert(String str, int left) {
		return str.substring(0, left + 1) + "()" + str.substring(left + 1);
	}

	public static void main(String[] args) {
		List<String> output = generateParenthesis(3);
		
		System.out.println(output);

	}

}
