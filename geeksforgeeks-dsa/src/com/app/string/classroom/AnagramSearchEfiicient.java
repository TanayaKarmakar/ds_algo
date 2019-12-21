package com.app.string.classroom;

public class AnagramSearchEfiicient {
	private static boolean isAnagramPresent(String txt, String pattern) {
		int[] countTxt = new int[256];
		int[] countPatt = new int[256];

		int windowSize = pattern.length();

		for (int i = 0; i < windowSize; i++) {
			countTxt[txt.charAt(i)]++;
			countPatt[pattern.charAt(i)]++;
		}

		for (int i = windowSize; i < txt.length(); i++) {
			if(areSame(countTxt, countPatt)) 
				return true;
			countTxt[txt.charAt(i)]++;
			countTxt[txt.charAt(i - windowSize)]--;
		}
		return false;
	}

	private static boolean areSame(int[] countTxt, int[] countPatt) {
		for (int i = 0; i < 256; i++) {
			if (countTxt[i] != countPatt[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Is Anagram present - " + 
				isAnagramPresent("geeksforgeeks", "egek"));
		
		System.out.println("Is Anagram present - " + 
				isAnagramPresent("geeksforgeeks", "gks"));

	}

}
