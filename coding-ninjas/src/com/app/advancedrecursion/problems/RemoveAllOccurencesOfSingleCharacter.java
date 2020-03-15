package com.app.advancedrecursion.problems;

import java.util.Arrays;

public class RemoveAllOccurencesOfSingleCharacter {
	private static void remove(char[] arr, char ch, int startIndx) {
		if(startIndx == arr.length)
			return;
		if(arr[startIndx] == ch) {
			int j;
			if(startIndx == 0) {
				j = 1;
			} else {
				j = startIndx + 1;
			}
			for(;j < arr.length;j++) {
				arr[j - 1] = arr[j];
			}
			arr[j - 1] = '\0';
			remove(arr, ch, startIndx);
		} else {
			remove(arr, ch, startIndx + 1);
		}
	}
	private static String removeOccurences(String str, char ch) {
		char[] arr = str.toCharArray();
		remove(arr, ch, 0);
		System.out.println(Arrays.toString(arr));
		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		String str = "xabc";
		
		str = removeOccurences(str, 'x');
		
		System.out.println(str);
		
		str = "abxbxcsvwxxxxx";
		
		str = removeOccurences(str, 'x');
		
		System.out.println(str);

		
	}

}
