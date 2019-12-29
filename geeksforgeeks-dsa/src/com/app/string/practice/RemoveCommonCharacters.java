package com.app.string.practice;

public class RemoveCommonCharacters {
	private static String removeAndConcat(String str1, String str2) {
		int[] str1Freq = new int[256];
		int[] str2Freq = new int[256];
		StringBuilder sb = new StringBuilder();

		int n = str1.length();

		for (int i = 0; i < n; i++) {
			str1Freq[str1.charAt(i)]++;
		}

		int m = str2.length();
		for (int i = 0; i < m; i++) {
			str2Freq[str2.charAt(i)]++;
		}

		for (int i = 0; i < n; i++) {
			char ch = str1.charAt(i);
			if (notCommon(str1Freq, str2Freq, ch)) {
				sb.append(ch);
			}
		}

		for (int j = 0; j < m; j++) {
			char ch = str2.charAt(j);
			if (notCommon(str1Freq, str2Freq, ch)) {
				sb.append(ch);
			}
		}

		return sb.toString();
	}

	private static boolean notCommon(int[] str1Freq, int[] str2Freq, char ch) {
		return !(str1Freq[ch] > 0 && str2Freq[ch] > 0) && !(str1Freq[ch] == 0 && str2Freq[ch] == 0);
	}

	public static void main(String[] args) {
		String str1 = "aacdb";
		String str2 = "gafd";

		System.out.println("Concatenated string - " + removeAndConcat(str1, str2));
	}

}
