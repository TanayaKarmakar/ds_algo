package com.app.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class InterleavingStringLeetcode97 {
	private static boolean isInterleaveHelper(Map<String, Boolean> map, String s1, String s2, 
			String s3, int mIndx, int nIndx, int pIndx) {
		if(mIndx == s1.length() && nIndx == s2.length() && pIndx == s3.length())
			return true;
		if(pIndx == s3.length())
			return false;
		String key = mIndx + "-" + nIndx + "-" + pIndx;
		if(map.get(key) == null) {
			boolean c1 = false;
			boolean c2 = false;
			if(mIndx < s1.length() && s1.charAt(mIndx) == s3.charAt(pIndx))
				c1 = isInterleaveHelper(map, s1, s2, s3, mIndx + 1, nIndx, pIndx + 1);
			if(nIndx < s2.length() && s2.charAt(nIndx) == s3.charAt(pIndx))
				c2 = isInterleaveHelper(map, s1, s2, s3, mIndx, nIndx + 1, pIndx + 1);
			map.put(key, (c1 || c2));
		}
		return map.get(key);
	}
	
	private static boolean isInterleave(String s1, String s2, String s3) {
		Map<String, Boolean> map = new HashMap<>();
		return isInterleaveHelper(map, s1, s2, s3, 0, 0, 0);
	}

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		
		System.out.println(isInterleave(s1, s2, s3));

	}

}
