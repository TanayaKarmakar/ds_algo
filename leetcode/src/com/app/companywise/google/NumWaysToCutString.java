package com.app.companywise.google;

// Given a string S, we can split S into 2 strings: S1 and S2. Return the number of ways S can be split such that the number 
//of unique characters between S1 and S2 are the same.
public class NumWaysToCutString {
	private static int numWays(String str) {
		int[] left = new int[26];
		int[] right = new int[26];
		
		for(int i = 0; i < str.length(); i++) {
			right[str.charAt(i) - 'a']++;
		}
		
		
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			left[str.charAt(i) - 'a']++;
			right[str.charAt(i) - 'a']--;
			
			boolean allMatch = true;
			for(int j = 0; j < 26; j++) {
				if((left[j] != 0 && right[j] == 0) || (left[j] == 0 && right[j] != 0)) {
					allMatch = false;
					break;
				}
			}
			if(allMatch) {
				count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		String str = "aaaa";
		
		int ans = numWays(str);
		
		System.out.println(ans);

	}

}
