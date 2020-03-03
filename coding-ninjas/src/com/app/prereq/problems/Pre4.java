package com.app.prereq.problems;

import java.util.Scanner;

public class Pre4 {
	private static void printCombinations(int[] teams, int n) {
		int end = n / 2;
		for (int i = 0; i < end; i++) {
			int el1 = teams[i];
			int el2 = teams[n - i - 1];
			System.out.println(((el1 + el2) / 10) + " " + ((el1 + el2) % 10));
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = Integer.parseInt(scanner.nextLine());
		String str = scanner.nextLine();
		int indx = 0;
		int[] teams = new int[nDim];
		for (String el : str.split("\\s+")) {
			teams[indx++] = Integer.parseInt(el);
		}
		printCombinations(teams, nDim);
		
		scanner.close();
	}

}
