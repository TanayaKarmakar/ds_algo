package com.app.augustchallenge;

import java.util.Scanner;

public class GoatLatin {
	private static boolean isVowel(char ch) {
		return (ch == 'a' || ch == 'e' || ch == 'i' 
				|| ch == 'o' || ch == 'u' || ch == 'A'
				|| ch == 'E' || ch == 'I' || ch == 'O'
				|| ch == 'U');
	}
	
	private static String toGoatLatin(String S) {
		String[] arr = S.split("\\s+");
		StringBuilder lastPartSb = new StringBuilder();
		lastPartSb.append("maa");
		
		StringBuilder respSb = new StringBuilder();
		
		for(String str: arr) {
			String newStr;
			if(isVowel(str.charAt(0)))
				newStr = str;
			else
				newStr = str.substring(1) + str.charAt(0);
			newStr = newStr + lastPartSb.toString();
			respSb.append(newStr);
			respSb.append(" ");
			
			lastPartSb.append("a");
		}
		return respSb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String text = scanner.nextLine();
		
		String res = toGoatLatin(text);
		
		System.out.println(res);
		
		scanner.close();

	}

}
