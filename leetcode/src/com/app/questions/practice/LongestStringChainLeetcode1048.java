package com.app.questions.practice;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChainLeetcode1048 {
	private static int longestStringChainEfficient(String[] words) {
		Arrays.sort(words, Comparator.comparingInt(String:: length));
		int n = words.length;
		int[] lsc = new int[n];
		Arrays.fill(lsc, 1);
		
		int maxLen = Integer.MIN_VALUE;
		for(int i = n - 1; i >= 0; i--) {
			String source = words[i];
			for(int j = i - 1; j >= 0; j--) {
				String target = words[j];
				if(source.length() == target.length())
					continue;
				if(source.length() != target.length() + 1)
					break;
				if(isPredecessor(source, target)) {
					lsc[j] = Integer.max(lsc[j], lsc[i] + 1);	
				}
				maxLen = Integer.max(maxLen, lsc[j]);
			}
			
		}
		//System.out.println(Arrays.toString(lsc));
		return maxLen;
	}
	
	private static boolean isPredecessor(String source, String target) {
		int srcIndx = 0;
		int trgtIndx = 0;
		int count = 0;
		while(trgtIndx < target.length()) {
			if(count > 1)
				return false;
			if(source.charAt(srcIndx + count) != target.charAt(trgtIndx))
				count++;
			else {
				srcIndx++;
				trgtIndx++;
			}
		}
		return true;
	}
	
	
	private static int longestStringChain(String[] words) {
		Arrays.sort(words, Comparator.comparingInt(String:: length));
		int n = words.length;
		int[] lsw = new int[n];

		int maxLen = Integer.MIN_VALUE;

		lsw[0] = 1;
		for (int i = 1; i < n; i++) {
			lsw[i] = 1;
			String str = words[i];
			if (str.length() == 1) {
				continue;
			}
			for (int k = 0; k < str.length(); k++) {
				String temp;
				if (k == 0) {
					temp = str.substring(1);
				} else if (k == str.length() - 1) {
					temp = str.substring(0, str.length() - 1);
				} else {
					temp = str.substring(0, k) + str.substring(k + 1);
				}
				//System.out.println(temp);
				for (int j = 0; j < i; j++) {
					if (temp.equals(words[j])) {
						lsw[i] = Integer.max(lsw[i], lsw[j] + 1);
					}
				}
			}
			maxLen = Integer.max(maxLen, lsw[i]);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String words[] = { "a", "b", "ba", "bca", "bda", "bdca" };

		int maxLen = longestStringChainEfficient(words);

		System.out.println(maxLen);

	}

}
