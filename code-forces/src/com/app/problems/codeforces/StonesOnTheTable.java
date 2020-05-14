package com.app.problems.codeforces;

import java.util.Scanner;

public class StonesOnTheTable {
	private static int getMinCount(int n, String str) {
		int i = 0;
		int j = 0;
		int count = 0;
		while(i < n) {
			j = i + 1;
			while(j < n && str.charAt(i) == str.charAt(j)) {
				j++;
			}
			count += (j - i) - 1;
			i = j;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String str = scanner.next();
		
		int count = getMinCount(n, str);
		
		System.out.println(count);
		scanner.close();
		
	}

}
