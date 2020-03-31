package com.app.dp1.problems;

import java.util.Scanner;

public class RoyAndCoins {
	private static int[] startPos;
	private static int[] endPos;
	private static int[] numCoinsBox;
	private static int[] revNumCoinsBox;

	private static void processBoxes(int n) {
		numCoinsBox[1] = startPos[1];
		numCoinsBox[2] = startPos[2] + startPos[1] - endPos[1];

		// calculates each box contains how many coins
		for (int i = 3; i <= n; i++) {
			numCoinsBox[i] = startPos[i] - endPos[i - 1] + numCoinsBox[i - 1];
		}

		// calculates how many boxes contains i number of coins
		for (int i = 1; i <= n; i++) {
			int k = numCoinsBox[i];
			revNumCoinsBox[k]++;
		}
		
		for(int i = n - 2; i >= 1; i--) {
			revNumCoinsBox[i] += revNumCoinsBox[i + 1];
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numBoxes = scanner.nextInt();
		startPos = new int[numBoxes + 1];
		endPos = new int[numBoxes + 1];
		numCoinsBox = new int[numBoxes + 1];
		revNumCoinsBox = new int[numBoxes + 1];

		int nDays = scanner.nextInt();
		while (nDays > 0) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			startPos[start]++;
			endPos[end]++;

			nDays--;
		}
		processBoxes(numBoxes);
		
		int nQueries = scanner.nextInt();
		while(nQueries > 0) {
			int number = scanner.nextInt();
			System.out.println(revNumCoinsBox[number]);
			nQueries--;
		}
		scanner.close();
	}

}
