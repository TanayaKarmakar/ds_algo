package com.app.heap.practice;

import java.util.Arrays;

public class HeapSort {
	private static void buildHeap(int[] arr, int n) {
		int size = (n - 2) / 2;
		for (int i = size; i >= 0; i--) {
			maxHeapify(arr, i, n);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static void maxHeapify(int[] arr, int i, int n) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (left < n && arr[largest] < arr[left])
			largest = left;
		if (right < n && arr[largest] < arr[right])
			largest = right;
		if (largest != i) {
			swap(arr, i, largest);
			maxHeapify(arr, largest, n);
		}
	}

	private static void heapSort(int[] arr) {
		int n = arr.length;
		buildHeap(arr, n);

		for (int i = n - 1; i >= 0; i--) {
			swap(arr, i, 0);
			maxHeapify(arr, 0, i);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 1, 3, 9, 7 };

		heapSort(arr);

		System.out.println(Arrays.toString(arr));
	}

}
