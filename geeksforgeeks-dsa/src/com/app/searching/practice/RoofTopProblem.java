package com.app.searching.practice;

public class RoofTopProblem {
	private static int findStepCount(int[] arr) {
		int n = arr.length;

		int count = 0;
		int start = 0;
		int maxCount = 0;
		
		while(start < n && (start + 1) < n && arr[start] > arr[start + 1]) {
			start++;
		}
		
		for(int i = start;i<n;i++) {
			if((i + 1) < n && arr[i] < arr[i + 1]) {
				count++;
				maxCount = Integer.max(maxCount, count);
			}
			else {	
				count = 0;
			}
		}
		
		return maxCount;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,2,3,2};
		
		System.out.println(findStepCount(arr));
		
		arr =  new int[] {1,2,3,4};
		System.out.println(findStepCount(arr));
	}

}
