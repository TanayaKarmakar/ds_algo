package com.app.questions;

import java.util.HashSet;
import java.util.Set;

public class ShortestWayToFormAString {
	private static int count = 0;
	private static int sIndx = 0;
	private static int tIndx = 0;
	
	private static void recursionHelper(String source, String target) {
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
			recursionHelper(source, target);
		} else {
			sIndx++;
			recursionHelper(source, target);
		}
	}
	
	private static int shortestWay(String source, String target) {
		Set<Character> sourceChars = new HashSet<>();
		for(int i = 0; i < source.length(); i++) {
			sourceChars.add(source.charAt(i));
		}
		
		for(int i = 0; i < target.length(); i++) {
			if(!sourceChars.contains(target.charAt(i)))
				return -1;
		}
		count = 0;
		sIndx = 0;
		tIndx = 0;
		recursionHelper(source, target);
		return count;	
	}

	public static void main(String[] args) {
		String source = "abc";
		String target = "abcbc";
		
		int minWays = shortestWay(source, target);
		
		System.out.println(minWays);
		
		source = "xyz";
		target = "xzyxz";
		
		minWays = shortestWay(source, target);
		
		System.out.println(minWays);
		
		source = "abc";
		target = "acdbc";
		
		minWays = shortestWay(source, target);
		
		System.out.println(minWays);

	}

}
