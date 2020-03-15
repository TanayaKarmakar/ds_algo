package com.app.advancedrecursion.problems;

public class FindStringLength {
	private static int findLen(String str) {
		if(str.equals(""))
			return 0;
		else
			return 1 + findLen(str.substring(1));
	}

	public static void main(String[] args) {
		String str = "";
		
		System.out.println(findLen(str));
		
		str = "java";
		
		System.out.println(findLen(str));

	}

}
