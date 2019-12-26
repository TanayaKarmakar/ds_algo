package com.app.string.practice;

public class RoatedString {
	private static boolean isRotated(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		else if(str1.length() == 1)
			return str1.equals(str2);
		else
			return (str1 + str1).indexOf(str2) >= 0;
	}

	public static void main(String[] args) {
		String str1 = "geeksforgeeks";
		String str2 = "forgeeksgeeks";
		
		System.out.println(isRotated(str1, str2));
		
		str1 = "mightandmagic";
		str2 = "andmagicmigth";
		
		System.out.println(isRotated(str1, str2));

	}

}
