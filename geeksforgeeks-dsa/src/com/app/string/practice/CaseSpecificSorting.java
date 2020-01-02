package com.app.string.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaseSpecificSorting {
	private static void caseSpecificSorting(String str) {
		List<Character> upperCaseLetters = new ArrayList<>();
		List<Character> lowerCaseLetters = new ArrayList<>();

		int n = str.length();
		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			if (ch >= 65 && ch <= 91) {
				upperCaseLetters.add(ch);
			} else if (ch >= 97 && ch <= 123) {
				lowerCaseLetters.add(ch);
			}
		}

		Collections.sort(upperCaseLetters);
		Collections.sort(lowerCaseLetters);

		StringBuilder sb = new StringBuilder();
		int lcIndx = 0;
		int ucIndx = 0;

		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			if (ch >= 65 && ch <= 91) {
				sb.append(upperCaseLetters.get(ucIndx));
				ucIndx++;
			} else if (ch >= 97 && ch <= 123) {
				sb.append(lowerCaseLetters.get(lcIndx));
				lcIndx++;
			}
		}

		System.out.println(sb.toString());

	}

	public static void main(String[] args) {
		String str = "defRTSersUXI";
		
		caseSpecificSorting(str);
		
		str = "gEeksfOrgEEkS";
		
		caseSpecificSorting(str);

	}

}
