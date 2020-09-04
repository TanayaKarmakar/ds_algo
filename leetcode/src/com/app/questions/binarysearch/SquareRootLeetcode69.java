package com.app.questions.binarysearch;

import java.util.Scanner;

public class SquareRootLeetcode69 {
	private static int mySqrt(int x) {
		long start = 1;
		long end = x;
		long ans = 0;
		while (start <= end) {
			long mid = start + (end - start) / 2;
			if (mid * mid == x)
				return (int)mid;
			else if (mid * mid > x)
				end = mid - 1;
			else {
				ans = mid;
				start = mid + 1;
			}
		}
		return (int)ans;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		
		int sqrt = mySqrt(num);
		
		System.out.println(sqrt);
		
		scanner.close();

	}

}
