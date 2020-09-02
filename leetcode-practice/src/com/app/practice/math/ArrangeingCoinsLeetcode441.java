package com.app.practice.math;

import java.util.Scanner;

public class ArrangeingCoinsLeetcode441 {
	private static int arrangeCoins(int n) {
		int i = 1;
		
		while(n >= i) {
			n = (n - i);
			i++;
		}
		
		return (i - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int ans = arrangeCoins(n);
		
		System.out.println(ans);

		scanner.close();
	}

}
