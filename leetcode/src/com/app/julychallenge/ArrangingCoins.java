package com.app.julychallenge;

import java.util.Scanner;

public class ArrangingCoins {
	private static int arrangeCoins(int n) {
		int stair = 1;
		while(n >= stair) {
			n = n - stair;
			stair++;
		}
		
		return stair - 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int ans = arrangeCoins(n);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
