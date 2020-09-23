package com.app.questions.bit;

import java.util.Arrays;
import java.util.List;

public class MaxLengthOfComcatenatedStringOfUniqueCharactersLeetcode1239 {

	private static int maxLength(List<String> arr) {
		int size = arr.size();
		int maxLen = 0;
		int maxSize = (int) Math.pow(2, size);

		for (int i = 1; i < maxSize; i++) {
			int temp = i;
			StringBuilder sb = new StringBuilder();

			int x = 0;
			int mask = 1;
			while (x < size) {
				if ((temp & mask) != 0) {
					sb.append(arr.get(x));
				}
				x++;
				mask = (mask << 1);
			}

			String str = sb.toString();
			int[] freq = new int[26];
			boolean duplicate = false;

			for (int j = 0; j < str.length(); j++) {
				int indx = str.charAt(j) - 'a';
				if (freq[indx] > 0) {
					duplicate = true;
					break;
				}
				freq[indx]++;
			}

			if (!duplicate)
				maxLen = Integer.max(maxLen, str.length());
		}

		return maxLen;

	}

	public static void main(String[] args) {
		List<String> str = Arrays.asList("un", "iq", "ue");

		int ans = maxLength(str);

		System.out.println(ans);

	}

}
