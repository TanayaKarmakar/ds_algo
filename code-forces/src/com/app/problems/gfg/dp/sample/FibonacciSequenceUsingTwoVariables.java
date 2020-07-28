package com.app.problems.gfg.dp.sample;

import java.util.Scanner;

public class FibonacciSequenceUsingTwoVariables {
	private static void printFib(int n) {
		if(n == 0) {
			System.out.println("0");
			return;
		}
		if(n == 1) {
			System.out.println("0 1");
			return;
		}
			
		int var1 = 1;
		int var2 = 1;
		
		System.out.print(0 + " ");
		for(int i = 1; i <= n; i++) {
			System.out.print(var1 + " ");
			
			int prev = var1;
			var1 = var2;
			var2 = prev + var1;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		printFib(n);
		
		scanner.close();

	}

}
