package com.app.questions.strings;

import java.util.Scanner;

public class StringCompressionLeetcode443 {
	private static int compress(char[] chars) {
		if (chars.length <= 1)
			return chars.length;
		int n = chars.length;
		int i = 0;
		int j = 0;

		while (i < n) {
			j = i + 1;
			int count = 1;
			while (j < n && chars[i] == chars[j]) {
				count++;
				j++;
			}
			if(count > 1) {
				String countStr = String.valueOf(count);
				int k = 0;
				i = i + 1;
				while(k < countStr.length()) {
					chars[i++] = countStr.charAt(k);
					k++;
				}
				
				for(k = i; k < j; k++) {
					chars[k] = ' ';
				}
			}
			i = j;
		}

		i = -1;
		for (j = 0; j < n; j++) {
			if (chars[j] != ' ') {
				i++;
				char tmp = chars[i];
				chars[i] = chars[j];
				chars[j] = tmp;
			}
		}

		return (i + 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		char[] chars = new char[n];
		for(int i = 0; i < n; i++) {
			chars[i] = scanner.next().charAt(0);
		}
		
		int len = compress(chars);
		
		for(int i = 0; i < len; i++) {
			System.out.print(chars[i]);
		}
		System.out.println();
		
		scanner.close();
	}

}
