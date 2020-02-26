package com.app.backtracking.classroom;

public class SubsetSumProblem {
	private static boolean findSubsetRec(int[] arr, int sum, int[] subset, int indx, int subsetIndx) {
		if (indx == arr.length)
			return false;
		if (arr[indx] == sum) {
			subset[subsetIndx] = arr[indx];
			return true;
		}
		for (int i = indx; i < arr.length; i++) {
			if (arr[i] > sum)
				continue;
			if (arr[i] == sum) {
				subset[subsetIndx] = arr[i];
				return true;
			}

			subset[subsetIndx] = arr[i];
			if (findSubsetRec(arr, sum - arr[i], subset, i + 1, subsetIndx + 1)) {
				return true;
			}
		}

		return false;
	}

	private static void findSubset(int[] arr, int sum) {
		int[] subset = new int[arr.length];
		boolean isSubsetFound = findSubsetRec(arr, sum, subset, 0, 0);
		if (isSubsetFound) {
			int temp = 0;
			int i = 0;
			while(temp != sum) {
				System.out.print(subset[i] + " ");
				temp = temp + subset[i];
				i++;
			}
			System.out.println();
		} else {
			System.out.println("No subset possible");
		}
	}

	public static void main(String[] args) {
		int[] arr = { 8, 3, 2, 10, 7 };
		findSubset(arr, 5);
		findSubset(arr, 12);
		findSubset(arr, 25);
	}

}
