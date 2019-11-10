package com.array.ideserve;

//this will work for only positive numbers
public class FindLengthOfSmallestArraySumEqualToK {
	private static int smallestSubArray(int[] arr, int k) {
		int len = Integer.MAX_VALUE;
		int left = 0;
		int windowSum = 0;
		int n = arr.length;
		for (int right = 0; right < n; right++) {
			windowSum += arr[right];

			while (windowSum >= k && left <= right) {
				len = Integer.min(len, (right - left + 1));

				windowSum -= arr[left];
				left++;
			}
		}

		if (len != Integer.MAX_VALUE)
			return len;
		else
			return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println("Length - " + smallestSubArray(arr, 21));
		
		System.out.println("Length - " + smallestSubArray(arr, 20));
	}

}
