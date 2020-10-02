package com.app.practice.strings;

import java.util.HashSet;
import java.util.Set;

public class ShortestWayToFormStringLeetcode1055 {
	private static int shortestWay(String source, String target) {
		int n = target.length();
		int count = 0;
		Set<Character> sourceSet = new HashSet<>();
		for (int i = 0; i < source.length(); i++) {
			sourceSet.add(source.charAt(i));
		}
		
		for(int i = 0; i < n; i++) {
			if (!sourceSet.contains(target.charAt(i)))
				return -1;
		}

		int i = 0;
		int j = 0;
		while (i < n) {
			if (j == source.length()) {
				count++;
				j = 0;
			}
			if (j < source.length() && source.charAt(j) == target.charAt(i)) {
				i++;
			}
			j++;
		}
		return count + 1;
	}

	public static void main(String[] args) {
		String source = "abc";
		String target = "abcbc";
		
		int count = shortestWay(source, target);
		
		System.out.println(count);

	}

}
