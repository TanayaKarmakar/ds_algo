package com.app.bitmagic.classroom;

import java.util.Scanner;

public class OddEvenNumber {
	private static void oddOrEven(int number) {
		if((number & 1) == 0) {
			System.out.println("Number is even");
		} else {
			System.out.println("Number is Odd");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		
		oddOrEven(Integer.parseInt(inputStr.trim()));
		
		scanner.close();
	}

}
