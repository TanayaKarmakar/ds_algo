package com.strings.basic;

import java.util.ArrayList;
import java.util.List;

//Asked by Amazon
// Rearrange characters in a string such that no two adjacent are same
public class NotSameAdjacentCharacter {
	private static void reArrange(String str) {
		str = str.toLowerCase();
		int n = str.length();
		int[] charArray = new int[26];
		int indx = 0;
		char maxCharFreq = 0;
		int maxFreq = 0;
		List<Character> ans = new ArrayList<>();

		// fill up frequency for each character
		// and find the character with maximum frequency
		for (int i = 0; i < n; i++) {
			indx = str.charAt(i) - 'a';
			charArray[indx]++;
			if(charArray[indx] > maxFreq) {
				maxFreq = charArray[indx];
				maxCharFreq = str.charAt(i);
			}
			ans.add(str.charAt(i));
		}

		if(maxFreq > (n + 1)/2)
			//return "Not possible";
			System.out.println("Not Possible");
		
		charArray[maxCharFreq - 'a'] = 0;
		
		int count = 0;
		int i = 1;
		while(count < 26) {
			if(charArray[count] > 0) {
				ans.set(i, (char)(count + 'a'));
				charArray[count]--;
				i = i + 2;
			} else {
				count++;
			}
			if(i >= n)
				i = 0;
		}
		i = 0;
		while(i < n) {
			ans.set(i, maxCharFreq);
			i = i + 2;
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		String str = "aaabc";
		reArrange(str);
		
		str = "aaaaabbbccc";		
		reArrange(str);

	}

}
