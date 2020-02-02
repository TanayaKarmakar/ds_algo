package com.app.string.practice;

//Given two strings string1 and string2, the task is to find the smallest 
//substring in string1 containing all characters of string2 efficiently.
public class SmallestWindowContainingAllChars {
	private static String smallestSubstring(String txt, String patt) {
		if (txt.length() < patt.length())
			return "No such window exists";
		int noOfChars = 256;

		int[] freqStr = new int[noOfChars];
		int[] freqPat = new int[noOfChars];

		for (int i = 0; i < patt.length(); i++) {
			freqPat[patt.charAt(i)]++;
		}

		int count = 0;
		int minLen = Integer.MAX_VALUE;
		int startIndx = -1;
		for (int j = 0; j < txt.length(); j++) {
			freqStr[txt.charAt(j)]++;
			
			if(freqPat[txt.charAt(j)] != 0 && 
					freqStr[txt.charAt(j)] <= freqPat[txt.charAt(j)]) {
				count++;
			}
			if(count == patt.length()) {
				int start = 0;
				while(freqStr[txt.charAt(j)] > freqPat[txt.charAt(j)] ||
						freqPat[txt.charAt(j)] == 0) {
					if(freqStr[txt.charAt(j)] > freqPat[txt.charAt(j)]) {
						freqStr[txt.charAt(j)]--;
					}
					start++;
				}
				
				if(minLen > (j - start + 1)) {
					minLen = (j - start + 1);
					startIndx = start;
				}
			}
		}
		
		if(startIndx == -1)
			return "-1";
		return txt.substring(startIndx , startIndx + minLen);
	}

	public static void main(String[] args) {
		String str = "this is a test string";
		String patt = "tist";
		
		System.out.println(smallestSubstring(str, patt));
	}

}
