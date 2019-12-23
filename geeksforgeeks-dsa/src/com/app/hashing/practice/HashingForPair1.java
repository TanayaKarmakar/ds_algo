package com.app.hashing.practice;

import java.util.HashSet;
import java.util.Set;

//Problem Statement -
//You are given an array A (distinct integers) of size N, 
//and you are also given a sum. You need to find if two 
//numbers in A exists that have sum equal to the given sum.
public class HashingForPair1 {
	private static int isPairExists(int[] arr, int sum) {
		Set<Integer> numSet = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (numSet.contains(sum - arr[i])) {
				return 1;
			} else {
				numSet.add(arr[i]);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println("Pair Exists - " + isPairExists(arr, 14));

		arr = new int[] { 2, 5 };

		System.out.println("Pair Exists - " + isPairExists(arr, 10));

	}

}
