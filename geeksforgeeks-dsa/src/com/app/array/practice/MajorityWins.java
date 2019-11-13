package com.app.array.practice;

public class MajorityWins {
	private static int majorityWins(int[] arr, int x, int y) {
		int countX = 0;
		int countY = 0;
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			if (arr[i] == x)
				countX++;
			else if (arr[i] == y)
				countY++;
		}

		return countX == countY ? Integer.min(x, y) : ((countX > countY) ? countX : countY);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5 };
		System.out.println(majorityWins(arr, 4, 5));

		arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(majorityWins(arr, 1, 7));
	}

}
