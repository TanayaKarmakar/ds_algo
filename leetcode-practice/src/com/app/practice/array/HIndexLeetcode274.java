package com.app.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class HIndexLeetcode274 {
	private static int hIndex(int[] citations) {
		Arrays.sort(citations);
		
		int n = citations.length;
		
		int i = 0;
		for(i = 1; i <= n; i++) {
			if(citations[n - i] < i)
				break;
		}
		
		return (i - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int hIndx = hIndex(nums);
		
		System.out.println(hIndx);
		
		scanner.close();

	}

}
