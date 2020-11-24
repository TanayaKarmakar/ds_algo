package com.app.practice.bitmagic;

import java.util.ArrayList;
import java.util.List;

public class MaximumLengthOfConcatenatedCharactersLeetcode1239 {
	private static int maxLength(List<String> arr) {
		if (arr.size() == 0)
			return 0;
		int size = arr.size();
		int totalCombinations = (int) Math.pow(2, size);
		int maxLen = 0;

		for (int i = 0; i < totalCombinations; i++) {
			int temp = i;
			StringBuilder sb = new StringBuilder();

			int j = 0;
			while (temp != 0) {
				if ((temp & 1) == 1) {
					sb.append(arr.get(j));
				}
				j++;
				temp = temp >> 1;
			}

			int[] chars = new int[26];

			String str = sb.toString();
			if (str.isEmpty())
				continue;
			boolean isUnique = true;
			for (int k = 0; k < str.length(); k++) {
				int indx = str.charAt(k) - 'a';
				if (chars[indx] > 0) {
					isUnique = false;
					break;
				}
				chars[indx]++;
			}

			if (isUnique) {
				maxLen = Integer.max(maxLen, str.length());
			}
		}

		return maxLen;
	}

	public static void main(String[] args) {
		List<String> arr = new ArrayList<>();
		arr.add("un");
		arr.add("iq");
		arr.add("ue");

		int ans = maxLength(arr);

		System.out.println(ans);

	}

}
