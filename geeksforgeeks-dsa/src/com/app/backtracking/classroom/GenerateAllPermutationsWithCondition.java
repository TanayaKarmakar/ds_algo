package com.app.backtracking.classroom;

public class GenerateAllPermutationsWithCondition {
	private static boolean isSafe(String str, int l, int i, int r) {
		if (l > 0 && str.charAt(l - 1) == 'A' && str.charAt(i) == 'B')
			return false;
		if (r == l + 1 && str.charAt(i) == 'A' && str.charAt(l) == 'B')
			return false;
		return true;
	}

	private static String swap(String str, int l, int r) {
		char[] charArr = str.toCharArray();
		char tmp = charArr[l];
		charArr[l] = charArr[r];
		charArr[r] = tmp;

		return String.valueOf(charArr);
	}

	// TBD
	private static void permute(String str, int l, int r) {
		if (l == r) {
			System.out.println(str);
			return;
		} else {
			for (int i = l; i <= r; i++) {
				if (isSafe(str, l, i, r)) {
					str = swap(str, i, l);
					permute(str, l + 1, r);
					str = swap(str, i, l);
				}
			}
		}
	}

	public static void main(String[] args) {
		String str = "ABC";

		permute(str, 0, str.length() - 1);

	}

}
