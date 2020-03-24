package com.app.adhoc.problems;

import java.util.Scanner;

public class WinningStrategy {
	private static void swap(int i1, int i2, int[] players) {
		int tmp = players[i1];
		players[i1] = players[i2];
		players[i2] = tmp;
	}

	private static void canWin(int n, int[] players) {
		int cost = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (players[i] != (i + 1)) {
				if (i - 1 >= 0 && players[i - 1] == (i + 1)) {
					swap(i, (i - 1), players);
					cost++;
				} else if (i - 2 >= 0 && players[i - 2] == (i + 1)) {
					swap(i - 1, i - 2, players);
					swap(i, i - 1, players);
					players[i] = i + 1;
					cost += 2;
				} else {
					System.out.println("NO");
					return;
				}
			}
		}

		System.out.println("YES");
		System.out.println(cost);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = scanner.nextInt();
		
		int[] nums = new int[nDim];
		
		for(int i = 0; i < nDim; i++) {
			nums[i] = scanner.nextInt();
		}
		
		canWin(nDim, nums);
		scanner.close();
	}

}
