package com.app.strings;

import java.util.Scanner;

public class LookAndSayProblem {
	private static String lookAndSay(int n) {
		String s = "1";
		for (int i = 1; i < n; i++) {
			s = nextString(s);
		}

		return s;
	}

	private static String nextString(String s) {
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		int i = 0;
		while (i < n) {
			int count = 1;
			int j = i + 1;
			while (j < n && s.charAt(i) == s.charAt(j)) {
				count++;
				j++;
			}
			sb.append(count + "" + s.charAt(i));
			i = j;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		String ans = lookAndSay(n);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
