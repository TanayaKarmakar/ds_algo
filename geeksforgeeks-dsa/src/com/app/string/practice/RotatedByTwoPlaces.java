package com.app.string.practice;

public class RotatedByTwoPlaces {
	private static boolean isRotatedTwoPlaces(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		else if(s1.length() == 1) {
			return s1.equals(s2);
		}
		else
			return (s1 + s1).indexOf(s2) == 2 
				|| (s1 + s1).indexOf(s2) == s1.length() - 2;
	}

	public static void main(String[] args) {
		String str1 = "amazon";
		String str2 = "azonam";
		
		System.out.println(isRotatedTwoPlaces(str1, str2));
		
		str1 = "geeksforgeeks";
		str2 = "geeksgeeksfor";
		
		System.out.println(isRotatedTwoPlaces(str1, str2));
		
		str1 = "b";
		str2 = "d";
		
		System.out.println(isRotatedTwoPlaces(str1, str2));
	}

}
