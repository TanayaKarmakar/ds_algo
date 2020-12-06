package com.app.strings;

import java.util.ArrayList;
import java.util.List;

public class SinusoidalString {
	private static String sinusoidalString(String s) {
		s = s.replaceAll("\\s+", "#");
		List<List<Character>> list = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			list.add(new ArrayList<>());
		}

		int n = s.length();
		int total = n / 3;

		int j = 0;
		int i = 0;
		int count = 0;
		while (i < total) {
			while (j < n && count < 3) {
				list.get(count).add(s.charAt(j));
				j++;
				count++;
			}

			count = count - 2;
			while (j < n && count >= 0) {
				list.get(count).add(s.charAt(j));
				count--;
				j++;
			}
			if (j == n)
				break;
			i++;
			count += 2;
		}

		System.out.println(list);

		StringBuilder sb = new StringBuilder();
		for (List<Character> row : list) {
			StringBuilder sb1 = new StringBuilder();
			for (Character ch : row) {
				sb1.append(ch);
			}
			sb.append(sb1.toString() + " ");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "Hello World!";

		String ans = sinusoidalString(s);

		System.out.println(ans);

	}

}
