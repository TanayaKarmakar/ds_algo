package com.app.string.classroom;


//given two string str1 and str2 check 
//if str2 is a rotation of str1
public class RotationOfAnother {
	private static boolean areRotation(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		str1 = str1 + str1;
		
		return str1.indexOf(str2) >= 0;
	}

	public static void main(String[] args) {
		System.out.println("Are Rotation - " + areRotation("abcd", "cdab"));
		System.out.println("Are Rotation - " + areRotation("abaa", "aaab"));
		System.out.println("Are Rotation - " + areRotation("abab", "abba"));
	}

}
