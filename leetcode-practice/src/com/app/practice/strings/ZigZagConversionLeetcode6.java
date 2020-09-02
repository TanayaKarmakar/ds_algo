package com.app.practice.strings;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversionLeetcode6 {
	private static String zigZag(String s, int numRows) {
		if(s.length() <= numRows || numRows <= 1)
			return s;
		int n = s.length();
		int i = 0;
		List<List<Character>> list = new ArrayList<>();
		for (int j = 0; j < numRows; j++) {
			list.add(new ArrayList<>());
		}

		while (i < n) {
			for (int j = 0; j < numRows && i < n; j++) {
				list.get(j).add(s.charAt(i));
				i++;
			}

			for (int j = numRows - 2; j > 0 && i < n; j--) {
				list.get(j).add(s.charAt(i));
				i++;
			}
		}
		
		System.out.println(list);

		StringBuilder sb = new StringBuilder();
		for (List<Character> chars : list) {
			StringBuilder sb1 = new StringBuilder();
			for (char ch : chars) {
				sb1.append(ch + "");
			}
			sb.append(sb1.toString());
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		int numRows = 4;
		
		String ans = zigZag(str, numRows);
		
		System.out.println(ans);

	}

}
