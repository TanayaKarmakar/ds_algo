package com.app.practice.strings;

import java.util.Scanner;

public class IsSubsequenceLeetcode392 {
	private static boolean isSubsequence(String s, String t) {
		int n = s.length();
		int m = t.length();
		
		int j = 0; 
		int i = 0;
		while(j < n && i < m) {
			if(s.charAt(j) == t.charAt(i)) {
				j++;
			}
			i++;
		}
		
		return j == n;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String source = scanner.next();
		String target = scanner.next();
		
		boolean isPossible = isSubsequence(source, target);
		
		System.out.println(isPossible);
		
		scanner.close();
	}

}
