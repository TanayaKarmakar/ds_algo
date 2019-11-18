package com.app.searching.classroom;

public class FindingTripletSumInSortedArray {
	private static boolean findTripletSumApproach2(int[] arr, int x) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (findPair(arr, i + 1, n - 1, x - arr[i])) {
				return true;
			}
		}
		return false;
	}

	private static boolean findPair(int[] arr, int start, int end, int x) {
		while (start < end) {
			if (arr[start] + arr[end] == x)
				return true;
			else if (arr[start] + arr[end] < x)
				start++;
			else
				end--;
		}
		return false;
	}

	private static boolean findTripletSum(int[] arr, int x) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			if (arr[start] + arr[end] > x)
				end--;
			else if (arr[start] + arr[end] < x) {
				for (int i = start + 1; i < end; i++) {
					if (arr[start] + arr[end] + arr[i] == x) {
						System.out.println(arr[start] + " " + arr[end] + " " + arr[i]);
						return true;
					}
				}
				start++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 4, 6, 8, 10, 20, 40 };
		findTripletSum(arr, 32);
		
		System.out.println("Find triplet sum approach2 - " + findTripletSumApproach2(arr, 32));
	}

}
