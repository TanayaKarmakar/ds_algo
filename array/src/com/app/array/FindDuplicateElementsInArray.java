package com.app.array;

//Find duplicates in O(n) time and O(1) extra space
// Given an array of n elements which contains elements from 0 to n-1, 
// with any of these numbers appearing any number of times. Find these repeating 
// numbers in O(n) and using only constant memory space.
public class FindDuplicateElementsInArray {
	private static void findDuplicateElements(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int indx = Math.abs(arr[i]);
			if(arr[indx] >= 0) {
				arr[indx] = -arr[indx];
			} else {
				System.out.print(indx + "\t");
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,1,4,5,3,5};
		
		findDuplicateElements(arr);

	}

}
