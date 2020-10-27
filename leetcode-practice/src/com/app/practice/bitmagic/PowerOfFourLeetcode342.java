package com.app.practice.bitmagic;

import java.util.Scanner;

public class PowerOfFourLeetcode342 {
	private static boolean isPowerOfFour(int num) {
		if(num == 1)
			return true;
		if((num & 1) == 1 || num <= 0)
			return false;
		int setBitCount = 0;
		int temp = num;
		while(temp != 0) {
			setBitCount++;
			temp = temp & (temp - 1);
		}
		
		if(setBitCount != 1)
			return false;
		
		int setBitPos = 0;
		temp = num;
		while(temp != 1) {
			temp = temp >> 1;
			setBitPos++;
		}
		
		return setBitPos % 2 == 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		boolean ans = isPowerOfFour(n);
		
		System.out.println(ans);
		
		scanner.close();
		
	}

}
