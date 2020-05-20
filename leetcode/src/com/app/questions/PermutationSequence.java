package com.app.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationSequence {
	private static int count = 0;

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static void permRec(int[] arr, int l, int r, int[] kThPerm, int k) {
		if(l == r) {
			if(++count == k) {
				System.out.println("Count is k");
				kThPerm = arr.clone();
			}				
		} else if(count < k) {
			for(int i = l;i<=r;i++) {
				swap(arr, i, l);
				permRec(arr, l + 1, r, kThPerm, k);
				swap(arr, i, l);
			}
		}
	}

	private static String getPermutation(int n, int k) {
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		
		int[] kThPerm = new int[n];
		permRec(nums, 0, nums.length - 1, kThPerm, k);
		
		return Arrays.toString(kThPerm).replaceAll("\\[|\\]|,|\\s", "");
	}

	public static void main(String[] args) {
		int n = 3;
		int k = 5;

		System.out.println(getPermutation(n, k));

	}

}
