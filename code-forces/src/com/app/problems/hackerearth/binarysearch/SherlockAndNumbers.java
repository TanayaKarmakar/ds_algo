package com.app.problems.hackerearth.binarysearch;

import java.util.Scanner;

public class SherlockAndNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int p = scanner.nextInt();
			boolean overflow = false;
			for(int i = 0; i < k; i++) {
				int num = scanner.nextInt();
				if(num <= p)
					p++;
				if(p > n) {
					overflow = true;
					break;
				}
			}
			if(overflow) {
				System.out.println("-1");
			} else {
				System.out.println(p);
			}
			
		}
		scanner.close();
	}

}
