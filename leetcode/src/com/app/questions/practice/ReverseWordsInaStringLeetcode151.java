package com.app.questions.practice;

public class ReverseWordsInaStringLeetcode151 {
	public static String reverseWords(String s) {
		String[] strs = s.split("\\s+");
		int start = 0;
		int end = strs.length - 1;
		while(start <= end) {
			String tmp = strs[start];
			strs[start] = strs[end];
			strs[end] = tmp;
			start++;
			end--;	
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < strs.length; i++) {
			sb.append(strs[i].trim()+ " ");
		}
		
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		String str = "the sky is blue";
		
		System.out.println(reverseWords(str));
		
		str = "  hello world!  ";
		
		System.out.println(reverseWords(str));
		
		str = "a good   example";
		
		System.out.println(reverseWords(str));

	}

}
