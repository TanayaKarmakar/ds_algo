package com.app.string.practice;

public class MaximumOccuringCharacter {
	private static char maxOccuringChar(String str) {
		int maxFreq = Integer.MIN_VALUE;
		int freqIndx = -1;

		int[] freq = new int[256];
		int n = str.length();
		for (int i = 0; i < n; i++) {
			freq[str.charAt(i)]++;
		}

		for (int i = 0; i < 256; i++) {
			if (freq[i] != 0 && freq[i] > maxFreq) {
				maxFreq = freq[i];
				freqIndx = i;
			}
		}

		return (char) freqIndx;
	}

	public static void main(String[] args) {
		String str = "testsample";
		
		System.out.println("MaxOccuring char - " + maxOccuringChar(str));
		
		str = "output";
		
		System.out.println("MaxOccuring char - " + maxOccuringChar(str));
	}

}
