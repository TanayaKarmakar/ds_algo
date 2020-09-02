package com.app.practice;

import java.util.Arrays;

public class IsomorphicStringsLeetcode205 {
	private static boolean isIsomorphic(String s, String t) {
		int[] sFreq = new int[256];
		int[] tFreq = new int[256];
		int[] sIndx = new int[256];
		int[] tIndx = new int[256];
		
		Arrays.fill(sIndx, -1);
		Arrays.fill(tIndx, -1);
		
		int n = s.length();
		for(int i = 0; i < n; i++) {
			sFreq[s.charAt(i)]++;
			tFreq[t.charAt(i)]++;
			sIndx[s.charAt(i)] = i;
			tIndx[t.charAt(i)] = i;
		}
		
		for(int i = 0; i < n; i++) {
			if(sFreq[s.charAt(i)] != tFreq[t.charAt(i)]
					|| sIndx[s.charAt(i)] != tIndx[t.charAt(i)])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "egg";
		String t = "add";
		
		System.out.println(isIsomorphic(s, t));
		
		s = "foo";
		t = "bar";
		
		System.out.println(isIsomorphic(s, t));
		
		s = "paper";
		t = "title";
		
		System.out.println(isIsomorphic(s, t));

	}

}
