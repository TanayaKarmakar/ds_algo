package com.app.questions;

public class LongestCommonPrefix {
	private static String lcpUtil(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		int n1 = str1.length();
		int n2 = str2.length();
		
		int i = 0;
		int j = 0;
		while(i < n1 && j < n2) {
			if(str1.charAt(i) != str2.charAt(j))
				break;
			sb.append(str1.charAt(i));
			i++;
			j++;
		}
		return sb.toString();
	}
	
	private static String longestCommonPrefix(String[] strs, int start, int end) {
		if(start == end)
			return strs[start];
		if(end > start) {
			int mid = start + (end - start)/2;
			String str1 = longestCommonPrefix(strs, start, mid);
			String str2 = longestCommonPrefix(strs, mid + 1, end);
			return lcpUtil(str1, str2);
		}	
		return null;
	}

	public static void main(String[] args) {
		String[] strs = {"flower", "flow", "flight"};
		
		System.out.println(longestCommonPrefix(strs, 0, strs.length - 1));
		
		strs = new String[] {"dog","racecar","car"};
		
		System.out.println(longestCommonPrefix(strs, 0, strs.length - 1));

	}

}
