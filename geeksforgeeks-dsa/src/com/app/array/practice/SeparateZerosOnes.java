package com.app.array.practice;

import java.util.Arrays;

public class SeparateZerosOnes {
	private static void separateZeroOnes(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		
		int i = start;
		int j = end;
		
		while(true) {
			while(arr[i] == 0) {
				i++;
			}
			
			while(arr[j] == 1) {
				j--;
			}
			
			if(i >= j)
				return;
			swap(arr, i, j);
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = {0, 1, 1, 0, 1, 0, 1};
		separateZeroOnes(arr);
		
		System.out.println("After modification");
		System.out.println(Arrays.toString(arr));

	}

}
