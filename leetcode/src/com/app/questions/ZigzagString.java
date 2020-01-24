package com.app.questions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ZigzagString {
	private static void zigZagString(String str, int nRows) {
		int n = str.length();
		int j = 0;
		int cnt = n / (2 * (nRows - 1));
		int cnt1 = 0;
		int i = 0;
		Map<Integer, List<Character>> wordMap = new LinkedHashMap<>();

		while (i <= cnt) {
			for (j = 0; j < nRows && cnt1 < n; j++) {
				if (!wordMap.containsKey(j)) {
					List<Character> charList = new ArrayList<>();
					charList.add(str.charAt(cnt1));
					wordMap.put(j, charList);
				} else {
					wordMap.get(j).add(str.charAt(cnt1));
				}
				cnt1++;
			}

			for (j = nRows - 2; j > 0 && cnt1 < n; j--) {
				if (!wordMap.containsKey(j)) {
					List<Character> charList = new ArrayList<>();
					charList.add(str.charAt(cnt1));
					wordMap.put(j, charList);
				} else {
					wordMap.get(j).add(str.charAt(cnt1));
				}
				cnt1++;
			}
			i++;

		}

		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, List<Character>> entry : wordMap.entrySet()) {
			List<Character> values = entry.getValue();
			for (Character el : values) {
				System.out.print(el);
				sb.append(el);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		zigZagString(str, 3);

		zigZagString(str, 4);
	}

}
