package com.app.string.practice;

public class PangramChecking {
	private static boolean isPangram(String str) {
		str = str.toLowerCase();

		int n = str.length();
		int[] freq = new int[26];

		for (int i = 0; i < n; i++) {
			int indx = str.charAt(i) - 'a';
			if (indx >= 0) {
				freq[indx]++;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (freq[i] == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "Bawds jog, flick quartz, vex nymph";
		System.out.println("Pangram - " + isPangram(str));

		str = "sdfs";
		System.out.println("Pangram - " + isPangram(str));
	}

}
