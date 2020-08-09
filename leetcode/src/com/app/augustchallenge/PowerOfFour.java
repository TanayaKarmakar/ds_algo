package com.app.augustchallenge;

import java.util.Scanner;

public class PowerOfFour {
	private static boolean isPowerOfFour(int num) {
		if(num < 0)
			return false;
		else if(num == 0 || num == 1)
			return true;
		int temp = num;
		int nSetBits = 0;
		
		while(temp != 0) {
			nSetBits++;
			temp = temp & (temp - 1);
		}
		
		int nZeroAfterSetBit = 0;
		temp = num;
		while(temp != 1) {
			nZeroAfterSetBit++;
			temp = temp >> 1;	
		}
		
		return nSetBits == 1 
				&& (nZeroAfterSetBit % 2 == 0);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		boolean ans = isPowerOfFour(num);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
