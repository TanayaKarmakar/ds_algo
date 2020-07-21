package com.app.nt1.problems;

import java.util.Scanner;

public class StrangeOrder {
	
	private static int[] computeLowestPrimeDivisor(int n) {
		int[] lpd = new int[n + 1];
		
		for(int i = 2; i <= n; i++) {
			lpd[i] = i;
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 2 * i; j <= n; j++) {
				if(lpd[j] == j)
					lpd[j] = i;
			}
		}
		
		return lpd;
	}
	
	private static void printIteration(int n, int[] lpdArr) {
		boolean[] marked = new boolean[n + 1];
		
		for(int i = n; i >= 2; i--) {
			if(!marked[i]) {
				int lpd = lpdArr[i];
				
			} 	
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] lpd = computeLowestPrimeDivisor(n);
		
	}

}
