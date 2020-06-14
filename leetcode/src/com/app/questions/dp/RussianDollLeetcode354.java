package com.app.questions.dp;

import java.util.Arrays;
import java.util.Comparator;

class ValueComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		if(o1[0] == o2[0])
			return o1[1] - o2[1];
		return o1[0] - o2[0];
	}
	
}

public class RussianDollLeetcode354 {
	//TBD
	private static int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, new ValueComparator());
		
		int n = envelopes.length;
		int[] lis = new int[n];
		
		lis[0] = 1;
		int maxLen = 1;
		for(int i = 1; i < n; i++) {
			lis[i] = 1;
			for(int j = 0; j < i; j++) {
				if(envelopes[i][0] > envelopes[j][0]
						&& envelopes[i][1] > envelopes[j][1]) {
					lis[i] = Integer.max(lis[i], lis[j] + 1);
				}
			}
			maxLen = Integer.max(maxLen, lis[i]);
		}
		
		return maxLen;
	}

	public static void main(String[] args) {
		int[][] env = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		int maxCount = maxEnvelopes(env);

		System.out.println(maxCount);

		env = new int[][] { { 4, 5 }, { 4, 6 }, { 6, 7 }, { 2, 3 }, { 1, 1 } };
		maxCount = maxEnvelopes(env);

		System.out.println(maxCount);
	}

}
