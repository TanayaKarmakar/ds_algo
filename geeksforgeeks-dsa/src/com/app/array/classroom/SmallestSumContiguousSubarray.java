package com.app.array.classroom;

//Kadane's algorithm
public class SmallestSumContiguousSubarray {
	private static void smallestSumContigousSubarray(int[] arr) {
		int n = arr.length;
		int localMin = 0;
		int globalMin = Integer.MAX_VALUE;
		
		for(int i = 0;i<n;i++) {
			localMin = Integer.min(arr[i], arr[i] + localMin);
			if(localMin < globalMin) {
				globalMin = localMin;
			}
		}
		
		System.out.println("Smallest sum - " + globalMin);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TC1
		smallestSumContigousSubarray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
		
		//TC2
		smallestSumContigousSubarray(new int[] { -4,-1,-9,-10});

	}

}
