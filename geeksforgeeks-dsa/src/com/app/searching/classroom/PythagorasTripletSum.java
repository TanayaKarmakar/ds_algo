package com.app.searching.classroom;

public class PythagorasTripletSum {
	private static boolean tripletSum(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] * arr[i];
		}

		for (int i = 0; i < n; i++) {
			if (isPythagorasProperty(arr, i + 1, n - 1, arr[i])) {
				return true;
			}
		}
		return false;
	}

	private static boolean isPythagorasProperty(int[] arr, int start, int end, int currentElem) {
		while (start < end) {
			int diff = arr[end] - arr[start];
			if (diff == currentElem)
				return true;
			else if (diff > currentElem) {
				end--;
			} else {
				start++;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		
		System.out.println(tripletSum(arr));
	}

}
