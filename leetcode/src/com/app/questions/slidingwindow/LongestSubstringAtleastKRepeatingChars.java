package com.app.questions.slidingwindow;

public class LongestSubstringAtleastKRepeatingChars {

	private static int longestSubstring(String s, int k) {
		int len = s.length();

		char[] freq = new char[26];
		for (int i = 0; i < len; i++) {
			freq[s.charAt(i) - 'a']++;
		}

		int i = 0;
		int j = len - 1;
		int left = 0;
		int right = len - 1;

		while (i <= j) {
			if (freq[s.charAt(i) - 'a'] < k) {
				while (left <= i) {
					freq[s.charAt(left) - 'a']--;
					left++;
				}
				j = right;
				i++;
			} else if (freq[s.charAt(j) - 'a'] < k) {
				while (right >= j) {
					freq[s.charAt(right) - 'a']--;
					right--;
				}
				i = left;
				j--;
			} else {
				i++;
				j--;
			}
		}
		
		return (right - left + 1);
	}

	public static void main(String[] args) {
		String str = "aaabb";

		int ans = longestSubstring(str, 3);
		System.out.println(ans);

		str = "ababbc";

		ans = longestSubstring(str, 2);
		System.out.println(ans);
	}

}
