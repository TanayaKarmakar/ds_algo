package com.app.problems.codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoyOrGirl {
	private static boolean isBoy(String str) {
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i));
		}
		
		if(set.size() % 2 != 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		if(isBoy(str)) {
			System.out.println("IGNORE HIM!");
		} else {
			System.out.println("CHAT WITH HER!");
		}
		
		scanner.close();
	}

}
