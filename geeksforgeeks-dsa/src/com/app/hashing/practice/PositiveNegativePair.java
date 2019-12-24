package com.app.hashing.practice;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PositiveNegativePair {
	private static String positiveNegativePair(int[] arr) {
		Set<Integer> numSet = new TreeSet<>();
		for(int i = 0;i<arr.length;i++) {
			if(arr[i] != 0) {
				numSet.add(arr[i]);
			}	
		}
		
		StringBuilder sb = new StringBuilder();
		for(Integer el: numSet) {
			if(el > 0) {
				return sb.toString().isEmpty() ? "0":sb.toString();
			}
			if(numSet.contains(-el)) {
				sb.insert(0, (-el) + " " + (el) + " ");
			}
		}
		
		return "0";
		
	}
	
//	public static void main(String[] args) {
//		int[] arr = {1,3,6,-2,-1,-3,2,7};
//		System.out.println(positiveNegativePair(arr));
//		
//		arr = new int[] {3,2,-3};
//		System.out.println(positiveNegativePair(arr));
//		
//		arr = new int[] {1,-3,1,-3,5};
//		System.out.println(positiveNegativePair(arr));
//	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		StringBuilder sb = new StringBuilder();

		while (nTestCases > 0) {
			int nDim = scanner.nextInt();
			int[] arr = new int[nDim];
			for (int i = 0; i < nDim; i++) {
				arr[i] = scanner.nextInt();
			}
			sb.append(positiveNegativePair(arr) + "\n");
			nTestCases--;
		}
		
		System.out.print(sb.toString());
		scanner.close();

	}

}
