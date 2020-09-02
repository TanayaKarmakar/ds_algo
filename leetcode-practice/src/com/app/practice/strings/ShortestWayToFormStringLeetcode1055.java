package com.app.practice.strings;

import java.util.HashSet;
import java.util.Set;

public class ShortestWayToFormStringLeetcode1055 {
	private static int shortestWay(String source, String target) {
		int m = source.length();
		int n = target.length();
		
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < m; i++) {
			set.add(source.charAt(i));
		}
		
		for(int i = 0; i < n; i++) {
			if(!set.contains(target.charAt(i)))
				return -1;
		}
		
		int count = 0;
		int i = 0;
		int j = 0;
		while(j < n) {
			if(i == m) {
				count++;
				i = 0;
			}
			
			if(source.charAt(i) == target.charAt(j)) {
				j++;
			}
			i++;	
		}
		return count + 1;
	}

	public static void main(String[] args) {
		String source = "abc";
		String target = "abcbc";
		
		int count = shortestWay(source, target);
		
		System.out.println(count);
		
		source = "abc";
		target = "acdbc";
		
		count = shortestWay(source, target);
		
		System.out.println(count);
		
		source = "xyz";
		target = "xzyxz";
		
		count = shortestWay(source, target);
		
		System.out.println(count);
	}

}
