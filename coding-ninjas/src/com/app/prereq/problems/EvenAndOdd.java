package com.app.prereq.problems;

import java.util.Scanner;

public class EvenAndOdd {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = Integer.parseInt(scanner.nextLine());
		int[] arr = new int[nDim];
		String numStr = scanner.nextLine();
		int indx = 0;
		for (String el : numStr.split("\\s+")) {
			arr[indx++] = Integer.valueOf(el);
		}

		int oddSum = 0;
		int evenSum = 0;
		for (int i = 0; i < nDim; i++) {
			if(i % 2 == 0 && arr[i] % 2 == 0) {
				evenSum += arr[i];
			}
			if(i % 2 != 0 && arr[i] % 2 != 0) {
				oddSum += arr[i];
			}
		}
		
		System.out.println(evenSum + " " + oddSum);
		scanner.close();
	}

}
