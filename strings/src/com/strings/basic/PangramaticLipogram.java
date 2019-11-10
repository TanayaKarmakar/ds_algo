package com.strings.basic;

public class PangramaticLipogram {
	private static boolean isPangramaticLipogram(String str) {
		boolean[] charIndx = new boolean[26];
		int indx = -1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				indx = str.charAt(i) - 'A';
			else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				indx = str.charAt(i) - 'a';

			charIndx[indx] = true;
		}

		int nMissingChars = 0;
		for (int i = 0; i < 26; i++) {
			if (charIndx[i] == false) {
				nMissingChars++;
			}
		}
		
		return nMissingChars == 1;
	}

	public static void main(String[] args) {

	}

}
