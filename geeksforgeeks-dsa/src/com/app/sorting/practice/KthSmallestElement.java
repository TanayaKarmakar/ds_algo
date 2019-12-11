package com.app.sorting.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {
	private static int[] createArray(String inputStr, int nDim) {
		int[] arr = new int[nDim];
		String[] strArr = inputStr.split("\\s+");

		int indx = 0;
		for (String str : strArr) {
			arr[indx++] = Integer.parseInt(str);
		}

		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;

		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, (i + 1), high);

		return (i + 1);
	}

	private static int kThSmallestElement(int[] arr, int low, int high, int k) {
		if(k > 0 && k <= (high - low) + 1) {
			int pIndx = partition(arr, low, high);
			if (pIndx == k - 1)
				return arr[pIndx];
			else if (pIndx > k) {
				return kThSmallestElement(arr, low, pIndx - 1, k);
			} else {
				return kThSmallestElement(arr, pIndx + 1, high, k);
			}
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nTestCases = Integer.parseInt(br.readLine());
		int i = 0;
		List<Integer> res = new ArrayList<>();
		while (i < nTestCases) {
			int nDim = Integer.parseInt(br.readLine());
			String strArr = br.readLine();

			int[] arr = createArray(strArr, nDim);
			int k = Integer.parseInt(br.readLine());
			res.add(kThSmallestElement(arr, 0, arr.length - 1, k));
			i++;
		}
		
		for(Integer el: res) {
			System.out.println(el);
		}
	}
}
