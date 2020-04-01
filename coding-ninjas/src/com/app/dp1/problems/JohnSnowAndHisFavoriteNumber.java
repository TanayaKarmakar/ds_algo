package com.app.dp1.problems;

import java.util.Scanner;

public class JohnSnowAndHisFavoriteNumber {
	private static final int MAX = 1026;

	private static int[] processArray(int[] countArr, int k, int x) {
		int[] marker = new int[MAX];

		for (int i = 0; i < k; i++) {
			int collect = 0;
			for (int j = 0; j < MAX; j++) {
				if (countArr[j] > 0) {
					int range = countArr[j];
					int add = range / 2;

					if ((collect + 1) % 2 == 1 && range % 2 == 1)
						add++;
					collect = collect + range;
					int xor = j ^ x;
					//System.out.println(xor);
					marker[xor] = marker[xor] + add;
					marker[j] = marker[j] + (countArr[j] - add);
				}

			}

			for (int j = 0; j < MAX; j++) {
				countArr[j] = marker[j];
				marker[j] = 0;
			}
		}

		int low = -1, high = -1;
		for (int j = 0; j < MAX; j++) {
			if (countArr[j] > 0) {
				low = j;
				break;
			}
		}

		for (int j = low + 1; j < MAX; j++) {
			if (countArr[j] > 0) {
				high = j;
			}
		}

		return new int[] { high, low };
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = scanner.nextInt();
		int k = scanner.nextInt();
		int x = scanner.nextInt();

		int[] countArr = new int[MAX];

		while (nDim > 0) {
			int val = scanner.nextInt();
			countArr[val]++;
			nDim--;
		}
		int[] vals = processArray(countArr, k, x);
		System.out.println(vals[0] + " " + vals[1]);
		scanner.close();
	}

}
