package com.array.ideserve;

//Boyer-Moore Majority Vote algorithm
public class FindMajorityElement {
	private static int findMajorityElement(int[] arr) {
		int n = arr.length;
		int candidate = arr[0];
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (count == 0) {
				candidate = arr[i];
				count = 1;
			} else {
				if (candidate == arr[i]) {
					count++;
				} else {
					count--;
				}
			}
		}
		
		//System.out.println(candidate);

		for (int i = 0; i < n; i++) {
			if (arr[i] == candidate)
				count++;
		}

		if (count > (n / 2))
			return candidate;
		else
			return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 7, 4, 4, 7, 4, 4, 9, 4, 3 };
		
		System.out.println("Majority element - " + findMajorityElement(arr));

		arr = new int[] {1,2,1,3,7};
		System.out.println("Majority element - " + findMajorityElement(arr));

	}

}
