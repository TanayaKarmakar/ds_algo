package com.app.dp2.problems;

import java.util.Scanner;

public class ShortestSuperSequencesRecursion {
	private static int getSmallest(String str1, String str2, int i, int j) {
		if (i >= str1.length() || j >= str2.length())
			return 1;
		if (str1.charAt(i) == str2.charAt(j))
			return 1 + getSmallest(str1, str2, i + 1, j + 1);
		else {
			int option1 = getSmallest(str1, str2, i + 1, j);
			int option2 = getSmallest(str1, str2, i, j + 1);
			return 1 + Integer.min(option1, option2);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		
		int ans = getSmallest(str1, str2, 0, 0);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
