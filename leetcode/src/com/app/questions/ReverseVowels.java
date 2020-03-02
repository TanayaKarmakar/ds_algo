package com.app.questions;

//TBD
public class ReverseVowels {
	private static boolean isVowel(char ch) {
		return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
				ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
	}
	
	private static void swap(char[] charArr, int i, int j) {
		char tmp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = tmp;
	}
	
	private static String reverseVowels(String s) {
		char[] charArr = s.toCharArray();
		
		int start = 0;
		int end = charArr.length - 1;
		while(start <= end) {
			while(start < charArr.length && !isVowel(charArr[start]) ) {
				start++;
			}
			if(start > end)
				return String.valueOf(charArr);
			while(end >= 0 && !isVowel(charArr[end])) {
				end--;
			}
			swap(charArr, start, end);
			start++;
			end--;
		}
		
		return String.valueOf(charArr);
	}

	public static void main(String[] args) {
		String str = ".,";
		
		System.out.println(reverseVowels(str));
		
		str = "leetcode";
		
		System.out.println(reverseVowels(str));
		
		str = "auieoo";
		
		System.out.println(reverseVowels(str));
		
		str = "hello";
		
		System.out.println(reverseVowels(str));
		
		str = "aA";
		
		System.out.println(reverseVowels(str));

	}

}
