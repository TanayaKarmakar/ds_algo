package com.app.practice.greedy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ShortestWayToFormAStringLeetcode1055 {
	private static int shortestWay(String source, String target) {
		Set<Character> set = new HashSet<>();
		
		int m = source.length();
		int n = target.length();
		
		for(int i = 0; i < m; i++) {
			set.add(source.charAt(i));
		}
		
		for(int i = 0; i < n; i++) {
			if(!set.contains(target.charAt(i)))
				return -1;
		}
		
		int i = 0; int j = 0;
		int count = 0;
		
		while(j < n) {
			if(i == m) {
				i = 0;
				count++;
			}
			
			if(source.charAt(i) == target.charAt(j)) {
				j++;
			}
			i++;
		}
		
		return count + 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String source = scanner.next();
		String target = scanner.next();
		
		int ans = shortestWay(source, target);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
