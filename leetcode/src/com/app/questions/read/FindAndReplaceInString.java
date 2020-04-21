package com.app.questions.read;

import java.util.Arrays;

public class FindAndReplaceInString {
	private static String findAndReplaceInString(String S, int[] indexes, String[] sources, String[] targets) {
		String res = new String(S);
		int n = S.length();
		int j = 0;
		
		for (int i = 0; i < indexes.length; i++) {
			int indx = -1;
			while(j < n) {
				indx = S.indexOf(sources[i], j);
				if(indx == -1 || indx == indexes[i])
					break;
				j = j + (indx + 1);
			}
			
			if (indx == indexes[i]) {
				res = res.replace(sources[i], targets[i]);
			}
		}
		return res;
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
