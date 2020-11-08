package com.app.practice.strings;

import java.util.HashSet;
import java.util.Set;

public class ShortestWayToFormStringLeetcode1055 {
	private static int shortestWay(String source, String target) {
		int n = source.length();
		int m = target.length();
		
		Set<Character> sourceSet = new HashSet<>();
		for(int i = 0; i < n; i++) {
			sourceSet.add(source.charAt(i));
		}
		
		for(int i = 0; i < m; i++) {
			if(!sourceSet.contains(target.charAt(i)))
				return -1;
		}
		
		int i = 0;
		int j = 0;
		int count = 0;
		
		while(j < m) {
			if(i == n) {
				count++;
				i = 0;
			}
			if(source.charAt(i) == target.charAt(j))
				j++;
			i++;
		}
		return count + 1;
	}

	public static void main(String[] args) {
		String source = "abc";
		String target = "abcbc";
		
		System.out.println(shortestWay(source, target));
		
		source = "xyz";
		target = "xzyxz";
		
		System.out.println(shortestWay(source, target));
		
		source = "abc";
		target = "acdbc";
		
		System.out.println(shortestWay(source, target));

	}

}
