package com.app.questions;

public class ReverseWords {
	private static String reverseWordsEfficient(String s) {
		s = s.trim();
		String[] arr = s.split("\\s+");
		
		StringBuilder sb = new StringBuilder();
		for(int i = arr.length - 1;i>=0;i--) {
			sb.append(arr[i]);
			sb.append(" ");
		}
		
		return sb.toString().trim();
	}
	
	private static String reverseWords(String s) {
		s = s.trim();
		String[] arr = s.split("\\s+");
		int start = 0;
		int end = arr.length - 1;
		while(start <= end) {
			String str = arr[start];
			arr[start] = arr[end];
			arr[end] = str;
			start++;
			end--;
		}
		
		return String.join(" ", arr);
	}

	public static void main(String[] args) {
		String str = "the sky is blue";
		System.out.println(reverseWordsEfficient(str));
		
		str = "      ";
		System.out.println(reverseWords(str));
		
		str = "tanaya";
		System.out.println(reverseWords(str));
	}

}
