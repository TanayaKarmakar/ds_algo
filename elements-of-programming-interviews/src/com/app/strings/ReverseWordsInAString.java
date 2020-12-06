package com.app.strings;

public class ReverseWordsInAString {
	private static String reverse(String word) {
		char[] arr = word.toCharArray();

		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			char ch = arr[start];
			arr[start] = arr[end];
			arr[end] = ch;
			start++;
			end--;
		}

		return new String(arr);
	}

	private static String reverseWords(String text) {
		String[] words = text.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			sb.append(reverse(word));
			sb.append(" ");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "ram is costly";

		str = reverseWords(str);

		System.out.println(str);
	}

}
