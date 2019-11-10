package com.app.problems;

//Problem statement - 
//Given an array of integers, find the first missing 
//positive integer in linear time and constant space. In other words, 
// find the lowest positive integer that does not exist in the array. 
// The array can contain duplicates and negative numbers as well.

//For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3


//solutions :-
//Following is the two step algorithm.

//1) Segregate positive numbers from others i.e., 
//	move all non-positive numbers to left side. In the following code, 
//  segregate() function does this part.
//2) Now we can ignore non-positive elements and consider only the part of array 
//   which contains all positive elements. We traverse the array containing all 
//   positive numbers and to mark presence of an element x, we change the 
//   sign of value at index x to negative. We traverse the array again and print the 
//   first index which has positive value. In the following code, findMissingPositive() function 
//   does this part. Note that in findMissingPositive, we have subtracted 1 from the values as 
//   indexes start from 0 in C.

public class FindTheSmallestPositiveNumber {
	private static int segregatePositiveNegatice(int[] arr) {
		int i = -1;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] < 0) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}

		return i;
	}

	private static int findSmallestMissingPositiveNumber(int[] arr) {
		int segIndx = segregatePositiveNegatice(arr);
		int n = arr.length;
		for (int i = segIndx + 1; i < n; i++) {
			int indx = Math.abs(arr[i]);
			if ((indx - 1) < n && arr[indx - 1] > 0) {
				arr[indx - 1] = -arr[indx - 1];
			}
		}

		for (int i = 0; i < n; i++) {
			if(arr[i] > 0) {
				return (i + 1);
			}
		}
		return segIndx + 1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 7, 6, 8, -1, -10, 15 };
		int smallestPositiveInt = findSmallestMissingPositiveNumber(arr);
		
		System.out.println("Smallest positive integer - " + smallestPositiveInt);
	}

}
