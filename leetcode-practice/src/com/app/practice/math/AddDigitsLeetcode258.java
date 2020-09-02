package com.app.practice.math;

import java.util.Scanner;

public class AddDigitsLeetcode258 {
	private static int addDigits(int num) {
		if(num <= 9)
			return num;
		int tmp = num;
		
		while(tmp % 10 != tmp) {
			int sum = 0;
			while(tmp != 0) {
				sum += (tmp % 10);
				tmp = tmp / 10;
			}
			tmp = sum;
		}
		
		return tmp;
	}
	
	private static int addDigitsEfficient(int num) {
		if(num == 0)
			return 0;
		if(num % 9 == 0)
			return 9;
		return (num % 9);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		int ans = addDigits(num);
		
		System.out.println("Normal - " + ans);
		
		ans = addDigitsEfficient(ans);
		
		System.out.println("Efficient - " + ans);
		
		scanner.close();

	}

}
