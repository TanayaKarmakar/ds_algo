package com.app.questions;

public class MaximumNumberOfBalloons {
	private static final String balloon = "balloon";
	private static boolean isAllZero(char[] charFreq) {
		for (int i = 1; i < 256; i++) {
			if (charFreq[0] != charFreq[i])
				return false;
		}
		return true;
	}

	private static int maxNumberOfBalloons(String text) {
		if(text.length() < balloon.length())
			return 0;
		char[] charFreq = new char[256];
		int n = text.length();
		for (int i = 0; i < n; i++) {
			charFreq[text.charAt(i)]++;
		}

		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (!isAllZero(charFreq)) {
			for (int i = 0; i < 7; i++) {
				if (charFreq[balloon.charAt(i)] > 0) {
					sb.append(balloon.charAt(i));
					charFreq[balloon.charAt(i)]--;
				} else {
					return count;
				}
			}
			if (sb.toString().equals(balloon)) {
				count++;
				sb = new StringBuilder();
			}
				
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println("Max Balloons - " + maxNumberOfBalloons("nlaebolko"));
		System.out.println("Max Balloons - " + maxNumberOfBalloons("loonbalxballpoon"));

	}

}
