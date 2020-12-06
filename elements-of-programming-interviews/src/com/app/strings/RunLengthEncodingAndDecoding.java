package com.app.strings;

public class RunLengthEncodingAndDecoding {
	private static String encode(String s) {
		StringBuilder sb = new StringBuilder();
		int n = s.length();

		int i = 0;
		int count = 0;
		while (i < n) {
			int j = i;
			count = 0;
			char ch = s.charAt(i);
			while (j < n && s.charAt(i) == s.charAt(j)) {
				j++;
				count++;
			}
			sb.append(count);
			sb.append(ch);

			i = j;
		}
		return sb.toString();
	}

	private static String decode(String s) {
		int n = s.length();

		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if(Character.isDigit(s.charAt(i))) {
				count = count * 10 + (s.charAt(i) - '0');
			} else {
				while (count > 0) {
					sb.append(s.charAt(i));
					count--;
				}
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "eeeaaaaaaaaaaffffee";

		String encodedStr = encode(s);

		System.out.println("Encoding - " + encodedStr);
		
		String decodedStr = decode(encodedStr);
		
		System.out.println("Decoding - " + decodedStr);
	}

}
