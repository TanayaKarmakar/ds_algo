package com.app.stringalgo.problems;

public class ZAlgorithm {
	private static int[] buildZ(String str) {
		int n = str.length();
		int[] Z = new int[n];
		
		Z[0] = 0;
		int l = 0;
		int r = 0;
		
		
		for(int i = 1; i < n; i++) {
			if(i > r) {
				l = i;
				r = i;
				while(r < n && str.charAt(r - l) == str.charAt(r)) {
					r++;
				}
				Z[i] = (r - l);
				r--;
			} else {
				int k = (i - l);
				if(Z[k] <= (r - i)) {
					Z[i] = Z[k];
				} else {
					l = i;
					while(r < n && str.charAt(r - l) == str.charAt(r)) {
						r++;
					}
					Z[i] = (r - l);
					r--;
				}
			}
		}
		return Z;
	}
	
	private static void searchString(String str, String pattern) {
		String str1 = pattern + "$" + str;
		int[] Z = buildZ(str1);
		
		for(int i = 0; i < str1.length(); i++) {
			if(Z[i] == pattern.length()) {
				System.out.print((i - pattern.length() - 1) + " ");
			}
		}
	}

	public static void main(String[] args) {
		String str = "aacyaacybaacyaacy";
		
		String pattern = "aacy";
		
		searchString(str, pattern);

	}

}
