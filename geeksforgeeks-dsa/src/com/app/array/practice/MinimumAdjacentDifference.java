package com.app.array.practice;

public class MinimumAdjacentDifference {
	private static int minAdjacentDiffence(int[] arr) {
		int minDiff = Integer.MAX_VALUE;
		int n = arr.length;
		int currentDiff = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {

			currentDiff = Math.abs(arr[i] - arr[i - 1]);

			if (currentDiff < minDiff) {
				minDiff = currentDiff;
			}
		}
		
		currentDiff = Math.abs(arr[n - 1] - arr[0]);
		if(currentDiff < minDiff)
			minDiff = currentDiff;

		return minDiff;
	}

	public static void main(String[] args) {
		 System.out.println("Min diff - " + minAdjacentDiffence(new int[] { 8,
		 -8, 9, -9, 10, -11, 12 }));
		 System.out.println("Min diff - " + minAdjacentDiffence(new int[] {
		 10, -3, -4, 7, 6, 5, -4, -1 }));
		 System.out.println("Min diff - " + minAdjacentDiffence(new int[] {
		 -1, 40, -14, 7, 6, 5, -4, -1 }));
		System.out.println("Min diff - "
				+ minAdjacentDiffence(new int[] { 524, 10, 364, 538, 523, -7, 634, 426, 201, 745, 125, 194, 166, 606,
						389, 256, -153, 595, 626, 584, 603, 660, 640, 682, -45, 373, 448, 495, 90, 305, 746, 166, -133,
						663, -96, 590, 208, 90, 568, -39, 35, -107, 355, 401, 51, -56, 210, 451, 91, 388, 235, 247 }));
	}

}
