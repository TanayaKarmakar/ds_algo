package com.app.questions.hashtable;

import java.util.Arrays;

public class PrisonCellAfterNDays {
	private static int[] calcCurrentState(int[] prevState) {
		int[] currentState = new int[prevState.length];

		for (int i = 1; i < prevState.length - 1; i++) {
			if (prevState[i - 1] == prevState[i + 1])
				currentState[i] = 1;
		}

		return currentState;
	}

	private static int[] reverse(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}

		return arr;
	}

	private static int[] prisonAfterNDays(int[] cells, int N) {
		int[][] cellStates = new int[7][];

		cellStates[0] = calcCurrentState(cells);
		for (int i = 1; i < 7; i++) {
			cellStates[i] = calcCurrentState(cellStates[i - 1]);
		}

		int div = (N - 1) / 7;
		int rem = (N - 1) % 7;

		if (div % 2 != 0) {
			int[] arr = Arrays.copyOf(cellStates[rem], cellStates[rem].length);
			return reverse(arr);
		} else
			return cellStates[rem];

	}

	public static void main(String[] args) {
		int[] cells = { 1, 0, 0, 1, 0, 0, 1, 0 };
		int N = 1000000000;

		System.out.println(Arrays.toString(prisonAfterNDays(cells, N)));
	}

}
