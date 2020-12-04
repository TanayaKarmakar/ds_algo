package com.app.practice.array;

import java.util.Arrays;

public class PrisonCellAfterNDaysLeetcode957 {
	private static int[] calcCellStates(int[] prevState) {
		int[] currentState = new int[prevState.length];

		for (int i = 1; i <= 6; i++) {
			int state = 0;
			if (prevState[i - 1] == prevState[i + 1])
				state = 1;
			currentState[i] = state;
		}

		return currentState;
	}

	private static void reverse(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}

	private static int[] prisonAfterNDays(int[] cells, int N) {
		int[][] cellStates = new int[7][];
		cellStates[0] = calcCellStates(cells);

		for (int i = 1; i < 7; i++) {
			cellStates[i] = calcCellStates(cellStates[i - 1]);
		}

		int div = (N - 1) / 7;
		int rem = (N - 1) % 7;

		int[] result = cellStates[rem];

		if (div % 2 != 0) {
			reverse(result);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] cells = { 0, 1, 0, 1, 1, 0, 0, 1 };
		int N = 7;
		
		System.out.println(Arrays.toString(prisonAfterNDays(cells, N)));

	}

}
