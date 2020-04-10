package com.app.questions;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesesLeetcode22 {
	public static List<String> generateParenthesis(int n) {
		if (n == 0) {
			List<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		List<String> res = generateParenthesis(n - 1);
		Set<String> newList = new LinkedHashSet<>();
		for (String el : res) {
			int len = el.length();
			for(int i = 0; i < len; i++) {
				if(el.charAt(i) == '(') {
					String newStr = el.substring(0, i + 1) + "()" +
							el.substring(i + 1);
					newList.add(newStr);
				}
			}
			newList.add(el + "()");
		}
		return new ArrayList<>(newList);
	}

	public static void main(String[] args) {
		List<String> res = generateParenthesis(7);
		
		System.out.println(res);
	}

}
