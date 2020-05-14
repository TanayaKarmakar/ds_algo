package com.app.problems.codeforces;

import java.util.Scanner;

public class FootBall {
	private static String isDangerous(String str) {
		int n = str.length();
		int i = 0;
		int j = 0;
		while(i < n) {
			j = i + 1;
			while(j < n && str.charAt(i) == str.charAt(j))
				j++;
			if(j - i >= 7)
				return "YES";
			i = j;
		}
		return "NO";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		System.out.println(isDangerous(str));
		scanner.close();
	}

}
