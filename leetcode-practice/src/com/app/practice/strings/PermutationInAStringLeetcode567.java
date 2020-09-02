package com.app.practice.strings;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationInAStringLeetcode567 {
	private static boolean checkInclusion(String s1, String s2) {
		if(s1.length() > s2.length())
            return false;
       int[] s1Array = new int[26];
		int[] s2Array = new int[26];
		
		int windowSize = s1.length();
		
		for(int i = 0; i < windowSize; i++) {
			s1Array[s1.charAt(i) - 'a']++;
			s2Array[s2.charAt(i) - 'a']++;
		}
		
		if(Arrays.equals(s1Array, s2Array))
			return true;
		
		int r = s1.length();
		int l = 0;
		while(r < s2.length()) {
			s2Array[s2.charAt(l) - 'a']--;
			s2Array[s2.charAt(r) - 'a']++;
			
			if(Arrays.equals(s1Array, s2Array))
				return true;
			l++;
			r++;
		}
		return false;
        
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.next();
		String s2 = scanner.next();
		
		boolean ans = checkInclusion(s1, s2);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
