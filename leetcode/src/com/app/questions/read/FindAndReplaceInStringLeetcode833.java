package com.app.questions.read;

import java.util.Arrays;

public class FindAndReplaceInStringLeetcode833 {
	private static String findAndReplaceInString(String S, int[] indexes, String[] sources, String[] targets) {
		int n = S.length();
		int[] match = new int[n];
		
		Arrays.fill(match, -1);
		
		for(int i = 0; i < indexes.length; i++) {
			int ix = indexes[i];
			String temp = S.substring(ix, ix + sources[i].length());
			if(temp.equals(sources[i])) {
				match[ix] = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int ix = 0;
		while(ix < n) {
			if(match[ix] >= 0) {
				sb.append(targets[match[ix]]);
				ix = ix + sources[match[ix]].length();
			} else {
				sb.append(S.charAt(ix++));
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(findAndReplaceInString("abcd", new int[] {0,2}, 
				new String[] {"a", "cd"}, new String[] {"eee","ffff"}));
		
		System.out.println(findAndReplaceInString("abcd", new int[] {0,2}, 
				new String[] {"ab", "ec"}, new String[] {"eee","ffff"}));

		String str = "wreorttvosuidhrxvmvo";
		int[] indices = { 14, 12, 10, 5, 0, 18 };
		String[] sources = { "rxv", "dh", "ui", "ttv", "wreor", "vo" };
		String[] targets = { "frs", "c", "ql", "qpir", "gwbeve", "n" };

		String res = findAndReplaceInString(str, indices, sources, targets);

		System.out.println(res);

	}

}
