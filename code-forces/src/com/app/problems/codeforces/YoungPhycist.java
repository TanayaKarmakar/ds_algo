package com.app.problems.codeforces;

import java.util.Scanner;

public class YoungPhycist {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int xSum = 0;
		int ySum = 0;
		int zSum = 0;
		while(n > 0) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int z = scanner.nextInt();
			xSum += x;
			ySum += y;
			zSum += z;
			n--;
		}
		if(xSum == 0 && ySum == 0 && zSum == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		scanner.close();

	}

}
