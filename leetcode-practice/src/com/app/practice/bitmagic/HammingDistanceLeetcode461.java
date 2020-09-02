package com.app.practice.bitmagic;

import java.util.Scanner;

public class HammingDistanceLeetcode461 {
	private static int hammingDistance(int x, int y) {
		int count = 0;
		while(x != 0 && y != 0) {
			int xVal = (x & 1);
			int yVal = (y & 1);
			if(xVal != yVal)
				count++;
			x = x >> 1;
			y = y >> 1;
		}
		
		while(x != 0) {
			if((x & 1) != 0)
				count++;
			x = x >> 1;
		}
		
		while(y != 0) {
			if((y & 1) != 0)
				count++;
			y = y >> 1;
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		int count = hammingDistance(x, y);
		
		System.out.println(count);
		
		scanner.close();
	}
}
