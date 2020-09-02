package com.app.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class RussianDollEnvelopesLeetcode354 {
	private static int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		Arrays.sort(envelopes, (e1, e2) -> {
			if(e1[0] == e2[0])
				return e1[1] - e2[1];
			return e1[0] - e2[0];
		});
		
		int[] lis = new int[n];
		lis[0] = 1;
		int maxSize = 1;
		for(int i = 1; i < n; i++) {
			lis[i] = 1;
			for(int j = 0; j < i; j++) {
				if(envelopes[j][0] < envelopes[i][0]
						&& envelopes[j][1] < envelopes[i][1]) {
					lis[i] = Integer.max(lis[i], lis[j] + 1);
				}
			}
			maxSize = Integer.max(maxSize, lis[i]);
		}
		
		return maxSize;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int[][] envelopes = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			envelopes[i] = new int[] {v1, v2};
		}
		
		int maxSize = maxEnvelopes(envelopes);
		
		System.out.println(maxSize);
		
		scanner.close();
	}

}
