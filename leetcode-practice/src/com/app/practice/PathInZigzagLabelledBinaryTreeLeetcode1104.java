package com.app.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathInZigzagLabelledBinaryTreeLeetcode1104 {
	private static List<Integer> pathInZigZagTree(int label) {
		List<Integer> res = new ArrayList<>();
		int height = (int) (Math.log(label) / Math.log(2)) + 1;
		int n = (int) Math.pow(2, height) - 1;
		int[] arr = new int[n];

		int i = 1;
		int start = 0;
		int end = 0;
		int element = 1;
		while(i <= height && start < n && end < n) {
			int nElements = (int)Math.pow(2, i - 1);
			end = start + nElements - 1;
			if(i % 2 != 0) {
				// starting from left to right
				for(int j = start; j <= end; j++) {
					arr[j] = element++;
				}
			} else {
				// starting from right to left
				for(int j = end; j >= start; j--) {
					arr[j] = element++;
				}
			}
			start = end + 1;
			i++;
		}
		
		System.out.println(Arrays.toString(arr));
		
		int loc = n - 1;
		while(arr[loc] != label) {
			loc--;
		}
		
		res.add(arr[loc]);
		
		while(loc > 0) {
			loc = (loc - 1)/2;
			res.add(0, arr[loc]);
		}	
		return res;
	}

	public static void main(String[] args) {
		int label = 1;
		
		List<Integer> res = pathInZigZagTree(label);
		
		System.out.println(res);
	}

}
