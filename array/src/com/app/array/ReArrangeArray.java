package com.app.array;

import java.util.Arrays;

// Given an array of n elements. Our task is to write a program to 
// rearrange the array such that elements at even positions are greater 
// than all elements before it and elements at odd positions are less than 
// all elements before it.
public class ReArrangeArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 4, 5, 6, 8, 8 };
		int[] aux = new int[arr.length];

		int start = 0;
		int end = arr.length - 1;
		
		Arrays.sort(arr);
		
		for (int i = arr.length - 1; i >= 0; i--) {
			if((i + 1)%2 == 0) {
				aux[i] = arr[end--];
			} else {
				aux[i] = arr[start++];
			}
		}
		
		System.out.println("Final result ");
		System.out.println(Arrays.toString(aux));
	}

}
