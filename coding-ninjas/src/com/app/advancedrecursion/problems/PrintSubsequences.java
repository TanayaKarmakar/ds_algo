package com.app.advancedrecursion.problems;

public class PrintSubsequences {
	private static void printSubs(String input, String output) {
		if(input.length() == 0) {
			System.out.println(output);
			return;
		}
		
		printSubs(input.substring(1), output);
		printSubs(input.substring(1), output + input.charAt(0));
	}

	public static void main(String[] args) {
		String str = "abc";
		
		printSubs(str, "");

	}

}
