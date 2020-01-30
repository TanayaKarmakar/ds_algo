package com.app.heap.classroom;

import java.util.Arrays;

public class HeapSort {
	private static void swap(int[] arr, int indx1, int indx2) {
		int tmp = arr[indx1];
		arr[indx1] = arr[indx2];
		arr[indx2] = tmp;
	}

	private static void maxHeapify(int[] arr, int i, int n) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && arr[largest] < arr[left]) {
			largest = left;
		}
		if (right < n && arr[largest] < arr[right]) {
			largest = right;
		}
		if (largest != i) {
			swap(arr, i, largest);
			maxHeapify(arr, largest, n);
		}
	}

	private static void buildHeap(int[] arr, int n) {
		for (int i = (n - 2) / 2; i >= 0; i--) {
			maxHeapify(arr, i, n);
		}
	}

	private static void heapSort(int[] arr) {
		int n = arr.length;
		buildHeap(arr, n);

		for (int i = n - 1; i >= 1; i--) {
			swap(arr, 0, i);
			maxHeapify(arr, 0, i);

		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 15, 50, 4, 20 };

		heapSort(arr);

		System.out.println("The array is ");
		System.out.println(Arrays.toString(arr));
	}

}
