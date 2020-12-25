package com.app.dynamicprogramming;

import java.util.Arrays;

public class RussianDollEnvelopes {
	private static int maxEnvelopes(int[][] envelopes) {
		if (envelopes.length <= 1)
			return envelopes.length;
		int n = envelopes.length;
		int[] lis = new int[n];
		Arrays.sort(envelopes, (e1, e2) -> e1[0] - e2[0]);

		lis[0] = 1;
		int maxLen = 1;
		for (int i = 1; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
					lis[i] = Integer.max(lis[i], lis[j] + 1);
				}
			}
			maxLen = Integer.max(maxLen, lis[i]);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };

		int maxLen = maxEnvelopes(envelopes);

		System.out.println(maxLen);

	}

}
