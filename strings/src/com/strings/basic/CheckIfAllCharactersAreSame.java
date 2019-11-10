package com.strings.basic;

public class CheckIfAllCharactersAreSame {
	private static boolean isAllSame(String str) {
		if(str == null || str.length() == 1)
			return true;
		
		int n = str.length();
		str = str.toLowerCase();
		for (int i = 0; i < n; i++) {
			if(str.charAt(0)!= str.charAt(i))
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		String str = "aaaaa";
		System.out.println("All characters are same - " + isAllSame(str));
		
		str = "tanaya";
		System.out.println("All characters are same - " + isAllSame(str));
	}

}
