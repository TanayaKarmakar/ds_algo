package com.app.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputeLastRowOfPascalsTriangle {
	// in O(n) space
	private static List<Integer> computeLastRow(int numRows) {
		List<Integer> prevRow = new ArrayList<>();
		List<Integer> currRow = null;

		prevRow.add(1);

		for (int i = 1; i < numRows; i++) {
			currRow = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				int val = 0;
				if (j > 0 && j < i)
					val = prevRow.get(j - 1) + prevRow.get(j);
				else
					val = 1;
				currRow.add(val);
			}

			prevRow = new ArrayList<>();
			for (Integer el : currRow) {
				prevRow.add(el);
			}
		}
		
		if(numRows % 2 == 0) {
			return currRow;
		} else
			return prevRow;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		List<Integer> res = computeLastRow(n);
		
		System.out.println(res);
		
		scanner.close();

	}

}
