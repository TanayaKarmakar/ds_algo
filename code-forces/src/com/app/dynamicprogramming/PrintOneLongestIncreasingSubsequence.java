package com.app.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LISNode {
	int len;
	List<Integer> list;
	
	public LISNode(int len, List<Integer> list) {
		this.len = len;
		this.list = list;
	}
} 

public class PrintOneLongestIncreasingSubsequence {
	private static void printOneLIS(int[] nums) {
		int n = nums.length;
		LISNode[] nodes = new LISNode[n];
		
		LISNode node = new LISNode(1, Arrays.asList(nums[0]));
		nodes[0] = node;
		
		List<Integer> result = null;
		int maxLen = 1;
		
		for(int i = 1; i < n; i++) {
			node = new LISNode(1, Arrays.asList(nums[i]));
			nodes[i] = node;
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					if(nodes[i].len < nodes[j].len + 1) {
						List<Integer> jList = nodes[j].list;
						nodes[i].len = nodes[j].len + 1;
						nodes[i].list = new ArrayList<>(jList);
						nodes[i].list.add(nums[i]);
					}
				}
			}
			if(maxLen < nodes[i].len) {
				maxLen = nodes[i].len;
				result = nodes[i].list;
			}
		}
		
		System.out.println("Length of LIS - " + maxLen);
		System.out.println("One of the LIS having " + maxLen + " is " + result);
	}

	public static void main(String[] args) {
		int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		printOneLIS(nums);

	}

}
