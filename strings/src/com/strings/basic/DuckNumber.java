package com.strings.basic;

public class DuckNumber {
	private static boolean isDuckNumber(String str) {
		if (str.length() == 1)
			return false;
		if (str.charAt(0) == '0')
			return false;
		int n = str.length();
		int zeroCount = 0;
		for (int i = 1; i < n; i++) {
			if (str.charAt(i) == '0')
				zeroCount++;
		}
		return zeroCount > 0;
	}

	public static void main(String[] args) {
		String input = "02345";
		System.out.println(input + " is a duck number " + isDuckNumber(input));
		
		input = "8050896";
		System.out.println(input + " is a duck number " + isDuckNumber(input));
	}

}
