package com.app.dp2.problems;

import java.util.Scanner;

public class SquareBracketsRecursion {
	private static int getValidCombinationCount(int oCount, int cCount, int total, boolean[] bIndices) {
		if(oCount > total || cCount > total)
			return 0;
		if(oCount == total && cCount == total)
			return 1;
		else if(oCount == cCount || bIndices[oCount + cCount] == true) {
			return getValidCombinationCount(oCount + 1, cCount, total, bIndices);
		} else if(oCount == total) {
			return getValidCombinationCount(oCount, cCount + 1, total, bIndices);
		} else {
			return getValidCombinationCount(oCount + 1, cCount, total, bIndices) 
					+ getValidCombinationCount(oCount, cCount + 1, total, bIndices);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDataSets = scanner.nextInt();

		while (nDataSets > 0) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			boolean[] bIndices = new boolean[2 * n];
			for(int i = 0; i < k; i++) {
				int val = scanner.nextInt();
				bIndices[val - 1] = true;
			}
			int nCombinations = getValidCombinationCount(0, 0, n, bIndices);
			System.out.println(nCombinations);
			nDataSets--;
		}
		scanner.close();
	}

}
