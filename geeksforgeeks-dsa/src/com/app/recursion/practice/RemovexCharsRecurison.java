package com.app.recursion.practice;

public class RemovexCharsRecurison {
	private static String removeChars(String str, int indx) {
		if(indx == str.length()) {
			return "";
		} else {
			if(str.charAt(indx) == 'x')
				return "" + removeChars(str, ++indx);
			else
				return str.charAt(indx) + removeChars(str, ++indx);
		}
	}

	public static void main(String[] args) {
		String str = "xaxb";
		System.out.println(removeChars(str, 0));

	}

}
