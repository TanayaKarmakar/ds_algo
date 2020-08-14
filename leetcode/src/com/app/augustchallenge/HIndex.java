package com.app.augustchallenge;

import java.util.Arrays;
import java.util.Scanner;

public class HIndex {
	private static int hIndex(int[] citations) {
		Arrays.sort(citations);
		
		int n = citations.length;
		int i;
		for(i = 1; i <= n; i++) {
			if(citations[n - i] < i)
				break;
		}
		
		return (i - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] citations = new int[n];
		
		for(int i = 0; i < n; i++) {
			citations[i] = scanner.nextInt();
		}
		
		int hIndx = hIndex(citations);
		
		System.out.println(hIndx);
		
		scanner.close();

	}

}
