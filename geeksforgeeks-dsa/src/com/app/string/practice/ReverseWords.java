package com.app.string.practice;

public class ReverseWords {
	private static void reverseWords(String[] str) {
		int start = 0;
		int end = str.length - 1;
		
		while(start <= end) {
			String tmp = str[start];
			str[start] = str[end];
			str[end] = tmp;
			start++;
			end--;
		}
		
		System.out.println(String.join(".", str));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = "i.like.this.program.very.much".split("\\.");
		reverseWords(str);
	}

}
