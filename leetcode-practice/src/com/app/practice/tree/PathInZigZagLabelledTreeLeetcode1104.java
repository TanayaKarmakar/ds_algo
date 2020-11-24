package com.app.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class PathInZigZagLabelledTreeLeetcode1104 {
	private static List<Integer> pathInZigZagTree(int label) {
		int height = (int) (Math.log(label) / Math.log(2) + 1);
		int totalSize = (int) Math.pow(2, height);

		int[] nums = new int[totalSize];

		int start = 0;
		int value = 1;
		
		for(int i = 0; i < height; i++) {
			int currentCount = (int)Math.pow(2, i);
			int end = start + currentCount;
			
			if(i % 2 == 0) {
				for(int j = start; j < end; j++) {
					nums[j] = value++;
				}	
			} else {
				for(int j = end - 1; j >= start; j--) {
					nums[j] = value++;
				}
			}
			
			start = end;
		}
		
		//System.out.println(Arrays.toString(nums));
		
		List<Integer> result = new ArrayList<>();
		int i = totalSize - 1;
		while(nums[i] != label) {
			i--;
		}
		
		while(i > 0) {
			result.add(0, nums[i]);
			i = (i - 1) /2;
		}
		
		result.add(0, nums[0]);
		
		return result;
	}

	public static void main(String[] args) {
		int label = 14;
		
		List<Integer> result = pathInZigZagTree(label);
		
		System.out.println(result);
	}

}
