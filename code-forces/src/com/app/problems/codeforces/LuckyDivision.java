package com.app.problems.codeforces;

import java.util.Scanner;

public class LuckyDivision {
	private static boolean isLucky(int number) {
		String strVal = String.valueOf(number);

		boolean isLucky = true;

		for (int i = 0; i < strVal.length(); i++) {
			if (strVal.charAt(i) != '4' && strVal.charAt(i) != '7') {
				isLucky = false;
				break;
			}
		}

		if (isLucky)
			return true;
		int[] luckyNumbers = { 4, 7, 44, 47, 74, 444, 447, 474, 477 };
		for(int i = 0; i < luckyNumbers.length; i++)
			if(number % luckyNumbers[i] == 0) return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();

		boolean isLucky = isLucky(number);
		if (isLucky)
			System.out.println("YES");
		else
			System.out.println("NO");
		scanner.close();
	}

}
