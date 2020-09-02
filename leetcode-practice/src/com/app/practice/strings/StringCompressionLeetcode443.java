package com.app.practice.strings;

public class StringCompressionLeetcode443 {
	private static int compress(char[] chars) {
		int n = chars.length;

		int i = 0;

		while (i < n) {
			int j = i + 1;
			int count = 1;
			while (j < n && chars[i] == chars[j]) {
				j++;
				count++;
			}

			if (count > 1) {
				String countStr = String.valueOf(count);
				int k = 0;
				i = i + 1;

				while (k < countStr.length()) {
					chars[i++] = countStr.charAt(k);
					k++;
				}

				for (k = i; k < j; k++) {
					chars[k] = ' ';
				}
			}

			i = j;
		}

		i = -1;
		for (int j = 0; j < n; j++) {
			if (chars[j] != ' ') {
				i++;
				char tmp = chars[j];
				chars[j] = chars[i];
				chars[i] = tmp;
			}
		}

		return i + 1;
	}

	public static void main(String[] args) {
		char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };

		int len = compress(chars);
		
		for(int i = 0; i < len; i++) {
			System.out.print(chars[i]);
		}
	}

}
