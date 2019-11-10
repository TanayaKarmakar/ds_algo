package com.strings.basic;

public class MissingCharsForPangram {
	private static void missingCharsForPangram(String str) {
		boolean[] charIndx = new boolean[26];

		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if (currentChar >= 'a' && currentChar <= 'z') {
				int indx = currentChar - 'a';
				if (!charIndx[indx]) {
					charIndx[indx] = true;
				}
			}
		}

		for (int i = 0; i < 26; i++) {
			if(charIndx[i] == false) {
				System.out.print((char)(i + 'a'));
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		missingCharsForPangram("welcome to geeksforgeeks");
		missingCharsForPangram("The quick brown fox jumps");
	}

}
