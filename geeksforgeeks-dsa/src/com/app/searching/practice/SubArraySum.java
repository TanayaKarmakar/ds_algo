package com.app.searching.practice;

public class SubArraySum {
	public static void findSubArraySum(int[] arr, int n, int sum) {
		int start = 0;
		int end = 0;
		int currentSum = 0;

		int i = 0;
		while (i < n) {
			if (currentSum < sum) {
				currentSum += arr[i];
				end = i;
				i++;
			}
			if (currentSum > sum) {
				currentSum -= arr[start];
				start++;
			}
			if (currentSum == sum) {
				System.out.println((start + 1) + " " + (end + 1));
				return;
			}
		}

		if (currentSum != sum) {
			System.out.println("-1");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };

		findSubArraySum(arr, arr.length, 10);
	}

}
