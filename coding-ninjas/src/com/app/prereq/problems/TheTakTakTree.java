package com.app.prereq.problems;

import java.util.Scanner;

public class TheTakTakTree {
	private static final int N_VILLAGERS = 11;
	
	private static void calculate(int n) {
		int nFullMoon = 0;
		while(n % N_VILLAGERS != 1) {
			nFullMoon++;
			n = 2 * n;
		}
		
		System.out.println(nFullMoon + " " + n);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nFruits = Integer.parseInt(scanner.nextLine());
		
		calculate(nFruits);
		scanner.close();

	}

}
