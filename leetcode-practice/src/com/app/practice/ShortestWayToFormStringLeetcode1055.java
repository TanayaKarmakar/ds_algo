package com.app.practice;

import java.util.HashSet;
import java.util.Set;

public class ShortestWayToFormStringLeetcode1055 {
	private static int sIndx = 0;
	private static int tIndx = 0;
	private static int count = 0;
	
	private static void findShortestWay(String source, String target) {
		if(tIndx == target.length()) {
			count++;
			return;
		}
		if(sIndx == source.length()) {
			count++;
			sIndx = 0;
		}
		if(source.charAt(sIndx) == target.charAt(tIndx)) {
			sIndx++;
			tIndx++;
			findShortestWay(source, target);
		} else {
			sIndx++;
			findShortestWay(source, target);
		}
	}
	private static int shortestWay(String source, String target) {
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < source.length(); i++) {
			set.add(source.charAt(i));
		}
		
		for(int i = 0; i < target.length(); i++) {
			if(!set.contains(target.charAt(i)))
				return -1;
		}
		
		sIndx = 0;
		tIndx = 0;
		count = 0;
		findShortestWay(source, target);
		return count;
	}

	public static void main(String[] args) {
		String source = "abc";
		String target = "abcbc";
		
		System.out.println(shortestWay(source, target));
		
		source = "abc";
		target = "acdbc";
		
		System.out.println(shortestWay(source, target));
		
		source = "xyz";
		target = "xzyxz";
		
		System.out.println(shortestWay(source, target));

	}

}
