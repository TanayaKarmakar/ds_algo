package com.app.problems.codeforces;

import java.util.Scanner;

public class ChatRoom {

	private static boolean isPossible(String str) {
		String pattern = "hello";
		int m = str.length();
		int n = pattern.length();
		
		int i = 0;
		int j = 0;
		int count = 0;
		while(i < m && j < n) {
			if(str.charAt(i) == pattern.charAt(j)) {
				j++;
				count++;
			} 
			i++;
		}
		
		return count == n;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		boolean isPossible = isPossible(str);
		
		if(isPossible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		scanner.close();
	}

}
