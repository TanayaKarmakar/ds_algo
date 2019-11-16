package com.app.array.classroom;

//Kadane's algorithm
// localMax = Integer.max(arr[i], arr[i] + localMax)
public class LargestSumContigousSubarray {
	private static void largestSumContiguousSubarray(int[] arr) {
		int n = arr.length;
		int localMax = 0;
		int globalMax = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			localMax = Integer.max(arr[i], arr[i] + localMax);
			if (localMax > globalMax) {
				globalMax = localMax;
			}
		}

		System.out.println("Largest sum - " + globalMax);
	}

	public static void main(String[] args) {
		// TC1
		largestSumContiguousSubarray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
		
		//TC2
		largestSumContiguousSubarray(new int[] { -4,-1,-9,-10});

	}

}
