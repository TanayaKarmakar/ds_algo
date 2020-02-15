package com.app.questions;

public class FindMissingNumber {
	private static void findMissingNumber(int[] arr) {
		int sum = 0;
		for(int i = 0;i<=arr.length;i++) {
			sum+=i;
		}
		
		for(int i = 0;i<arr.length;i++) {
			sum -= arr[i];
		}
		
		System.out.println("Sum - " + sum);
	}

	public static void main(String[] args) {
		int[] arr = { 3, 0, 1 };
		//System.out.println(
		findMissingNumber(arr);

		arr = new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		//System.out.println(
		findMissingNumber(arr);
	}

}
