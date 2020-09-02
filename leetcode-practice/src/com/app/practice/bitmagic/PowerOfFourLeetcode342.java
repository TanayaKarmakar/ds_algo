package com.app.practice.bitmagic;

import java.util.Scanner;

public class PowerOfFourLeetcode342 {
	private static boolean isPowerOfFour(int num) {
		if(num == 0)
			return true;
		if((num & 1) == 1 || num < 0)
			return false;
		int tmp = num;
		int count = 0;
		while(tmp != 0) {
			count++;
			tmp = (tmp & (tmp - 1));
		}
		
		if(count > 1)
			return false;
		int countZeroAfterSetBit = 0;
		
		tmp = num;
		while(tmp != 1) {
			countZeroAfterSetBit++;
			tmp = tmp >> 1;
		}
		
		if(countZeroAfterSetBit % 2 == 0)
			return true;
		else 
			return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		
		boolean isPowerOfFour = isPowerOfFour(num);
		
		System.out.println(isPowerOfFour);
		
		scanner.close();

	}

}
