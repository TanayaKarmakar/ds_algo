package com.app.greedy.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NikunjAndDonuts {
	private static int findMinCalorieIntake(Integer[] cakes) {
		Arrays.sort(cakes, Collections.reverseOrder());
		
		int n = cakes.length;
		
		int total = 0;
		for(int i = 0; i < n; i++) {
			total += (cakes[i] * (1 << i));
		}
		
		return total;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = scanner.nextInt();
		
		Integer[] cakes = new Integer[nDim];
		for(int i = 0; i < nDim; i++) {
			cakes[i] = scanner.nextInt();
		}
		
		int minCalIntake = findMinCalorieIntake(cakes);
		
		System.out.println(minCalIntake);
		scanner.close();
	}
}
