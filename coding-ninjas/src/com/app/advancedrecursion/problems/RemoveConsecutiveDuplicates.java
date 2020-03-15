package com.app.advancedrecursion.problems;

public class RemoveConsecutiveDuplicates {
	private static void removeConsecutiveDuplicates(char[] arr, int startIndx, int n) {
		if (startIndx == n)
			return;
		else {
			if (startIndx + 1 < n) {

				int endIndx = startIndx + 1;
				while (endIndx < n && arr[startIndx] == arr[endIndx]) {
					endIndx++;
				}
				for (int i = startIndx + 1; i < endIndx; i++) {
					arr[i] = Character.MIN_VALUE;
				}
				startIndx = endIndx;
				removeConsecutiveDuplicates(arr, startIndx, n);

			}
		}
	}

	private static String removeConsecutiveDuplicates(String str) {
		char[] arr = str.toCharArray();
		removeConsecutiveDuplicates(arr, 0, str.length());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != Character.MIN_VALUE) {
				sb.append(arr[i]);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "aabccba";

		System.out.println(removeConsecutiveDuplicates(str));

		str = "aaaa";

		System.out.println(removeConsecutiveDuplicates(str));

		str = "baabbsbbahsahbahshhbhsjjjj";

		System.out.println(removeConsecutiveDuplicates(str));

	}

}
