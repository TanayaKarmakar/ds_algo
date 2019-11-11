package com.app.recursion.practice;

import java.util.ArrayList;
import java.util.List;

public class PossiblePhoneDigits {
	private static String[] codes = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

	private static List<String> possiblePatterns(String str) {
		if (str.length() == 0) {
			List<String> list = new ArrayList<>();
			list.add("");
			return list;
		}

		char ch = str.charAt(0);

		String rest = str.substring(1);
		List<String> prevRes = possiblePatterns(rest);
		List<String> result = new ArrayList<>();

		String code = codes[ch - '0'];

		// for (String val : prevRes) {
		// for (int i = 0; i < code.length(); i++) {
		// result.add(code.charAt(i) + val);
		// }
		// }

		for (int i = 0; i < code.length(); i++) {
			for (String val : prevRes) {
				result.add(code.charAt(i) + val);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(possiblePatterns("234"));
	}

}
