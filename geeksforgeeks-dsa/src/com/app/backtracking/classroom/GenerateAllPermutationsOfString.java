package com.app.backtracking.classroom;

public class GenerateAllPermutationsOfString {
	private static String swap(String str, int i, int j) {
		char[] charArr = str.toCharArray();
		char tmp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = tmp;

		return String.valueOf(charArr);
	}

	private static void permute(String str, int i, int j) {
		if (i == j) {
			System.out.println(str);
			return;
		} else {
			for (int k = i; k <= j; k++) {
				str = swap(str, i, k);
				permute(str, i + 1, j);
				str = swap(str, i, k);
			}
		}
	}

	public static void main(String[] args) {
		String str = "abc";
		
		permute(str, 0, str.length() - 1);

	}

}
