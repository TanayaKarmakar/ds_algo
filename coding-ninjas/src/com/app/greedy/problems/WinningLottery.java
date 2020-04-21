package com.app.greedy.problems;

import java.util.Scanner;

public class WinningLottery {
	private static void printMinNumber(int sum, int digits) {
		int[] number = new int[digits];
		int temp = sum - 1;
		for(int i = digits - 1; i >= 1; i--) {
			if(temp > 9) {
				number[i] = 9;
				temp = temp - 9;	
			} else {
				if(temp == 0) {
					break;
				}
				if(temp > 1) {
					number[i] = temp;
					temp = 0;
				}
			}
		}
		number[0] = temp + 1;
		StringBuilder sb = new StringBuilder();
		for(int el: number) {
			sb.append(el);
		}
		
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = scanner.nextInt();
		int digit = scanner.nextInt();
		
		printMinNumber(sum, digit);
		
		scanner.close();
	}

}
