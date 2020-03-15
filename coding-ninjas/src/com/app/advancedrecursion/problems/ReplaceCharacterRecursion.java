package com.app.advancedrecursion.problems;

public class ReplaceCharacterRecursion {
	private static void replaceCharacters(char[] arr, char ch1, char ch2, int startIndx) {
		if(startIndx == arr.length)
			return;
		if(arr[startIndx] == ch1) {
			arr[startIndx] = ch2;
		}
		replaceCharacters(arr, ch1, ch2, startIndx + 1);
	}
	
	private static String replaceCharacters(String input, char ch1, char ch2) {
		char[] arr = input.toCharArray();
		replaceCharacters(arr, ch1, ch2, 0);
		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		String str = "abacd";
		
		System.out.println(replaceCharacters(str, 'a', 'x'));
		
		str = ""; 
		
		System.out.println(replaceCharacters(str, 'a', 'x'));

	}

}
