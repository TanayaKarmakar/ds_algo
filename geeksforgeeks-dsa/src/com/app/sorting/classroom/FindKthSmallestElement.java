package com.app.sorting.classroom;

public class FindKthSmallestElement {
	private static int partition(int[] arr, int left, int right) {
		int i = left - 1;
		int pivot = arr[right];
		for(int j = left;j <= right - 1;j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, (i + 1), right);
		return (i + 1);
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	private static int findKthSmallestElement(int[] arr, int k) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			int pIndx = partition(arr, left, right);
			if(pIndx == k - 1)
				return pIndx;
			else if(pIndx > k - 1) {
				right = pIndx - 1;
			} else {
				left = pIndx + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {10,2,3,7,5,4,8,1,9};
		System.out.println("Kth Smallest element - " + arr[findKthSmallestElement(arr, 5)]);
	}

}
