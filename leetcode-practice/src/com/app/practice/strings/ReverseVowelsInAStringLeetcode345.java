package com.app.practice.strings;

import java.util.Scanner;

public class ReverseVowelsInAStringLeetcode345 {
	private static boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' ||
				ch == 'o' || ch == 'u'|| ch == 'A' ||
                ch == 'E' || ch == 'I' || ch == 'O' ||
                ch == 'U';
	}
	
	private static String reverseVowels(String s) {
		char[] arr = s.toCharArray();
		int start = 0;
		int end = arr.length - 1;
		while(start < end) {
			if((isVowel(arr[start]) && isVowel(arr[end])) || (!isVowel(arr[start]) && !isVowel(arr[end]))) {
				if(isVowel(arr[start]) && isVowel(arr[end])) {
					char tmp = arr[start];
					arr[start] = arr[end];
					arr[end] = tmp;
				}
				start++;
				end--;
			} else {
				if(!isVowel(arr[start]))
					start++;
				else
					end--;
			}
		}
		
		return new String(arr);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String text = scanner.nextLine();
		
		System.out.println(reverseVowels(text));
		
		scanner.close();

	}

}
