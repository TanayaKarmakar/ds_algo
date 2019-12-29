package com.app.recursion.practice;

public class RemoveConsecutiveDuplicates {
	private static String removeDupsAlternate(String str, int startIndx) {
		if (str.length() == 1)
			return str;
		else if (startIndx >= str.length())
			return "";
		String smallOutput = removeDupsAlternate(str, startIndx + 2);
		if (smallOutput.isEmpty()) {
			if (startIndx + 1 < str.length()) {
				if (str.charAt(startIndx) == str.charAt(startIndx + 1))
					return String.valueOf(str.charAt(startIndx));
				else
					return String.valueOf(str.charAt(startIndx)) 
							+ String.valueOf(str.charAt(startIndx + 1));
			}
		}
		if (startIndx + 1 < str.length()) {
			if (str.charAt(startIndx) == str.charAt(startIndx + 1)) {
				if (smallOutput.charAt(0) == str.charAt(startIndx))
					return smallOutput;
				else
					return String.valueOf(str.charAt(startIndx)) + smallOutput;
			} else if (str.charAt(startIndx + 1) == smallOutput.charAt(0))
				return String.valueOf(str.charAt(startIndx)) + smallOutput;
			else {
				return String.valueOf(str.charAt(startIndx)) 
						+ String.valueOf(str.charAt(startIndx + 1)) + smallOutput;
			}
		} else {
			return smallOutput;
		}

	}

	private static String removeDups(String str, int startIndx) {
		if (str.length() == 1)
			return str;
		else if (startIndx >= str.length())
			return "";
		else {
			if (startIndx + 1 < str.length()) {
				if (str.charAt(startIndx) == str.charAt(startIndx + 1)) {
					int endIndx = startIndx + 1;
					while (endIndx < str.length() && str.charAt(startIndx) == str.charAt(endIndx)) {
						endIndx++;
					}
					return String.valueOf(str.charAt(startIndx)) + removeDups(str, endIndx);
				} else
					return String.valueOf(str.charAt(startIndx)) + removeDups(str, startIndx + 1);
			} else {
				return str.charAt(startIndx) + removeDups(str, startIndx + 1);
			}
		}
	}

	public static void main(String[] args) {
		String str = "aabbbcddddd";

		System.out.println(removeDupsAlternate(str, 0));

		str = "aabccba";

		System.out.println(removeDupsAlternate(str, 0));

		str = "aaabcdddd";

		System.out.println(removeDupsAlternate(str, 0));

		str = "baabbsbbahsahbahshhbhsjjjj";

		System.out.println(removeDupsAlternate(str, 0));

		str = "aaaa";

		System.out.println(removeDupsAlternate(str, 0));

		str = "aaabcddddd";

		System.out.println(removeDupsAlternate(str, 0));

		/*
		 * String str = "aabccba";
		 * 
		 * System.out.println(removeDups(str, 0));
		 * 
		 * str = "aabccd";
		 * 
		 * System.out.println(removeDups(str, 0));
		 * 
		 * str = "aaabcdddd";
		 * 
		 * System.out.println(removeDups(str, 0));
		 * 
		 * str = "baabbsbbahsahbahshhbhsjjjj";
		 * 
		 * System.out.println(removeDups(str, 0));
		 * 
		 * str = "aaaa";
		 * 
		 * System.out.println(removeDups(str, 0));
		 */
	}

}
