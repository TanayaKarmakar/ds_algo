package com.app.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintAllLIS {
	static class LISNode {
		int indx;
		int lisLen;
		int arrValue;
		String pathSoFar;
		
		public LISNode(int indx, int lisLen, int arrValue, String pathSoFar) {
			this.indx = indx;
			this.lisLen = lisLen;
			this.arrValue = arrValue;
			this.pathSoFar = pathSoFar;
		}
	}
	
	private static List<String> printAllLis(int[] nums) {
		int n = nums.length;
		int[] lis = new int[n];

		int max = 1;

		lis[0] = 1;
		for (int i = 1; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					lis[i] = Integer.max(lis[i], lis[j] + 1);
				}
			}

			max = Integer.max(max, lis[i]);
		}

		Queue<LISNode> queue = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			if(max == lis[i]) {
				queue.add(new LISNode(i, max, nums[i], nums[i] + ""));
			}
		}
		
		List<String> results = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			LISNode rem = queue.poll();
			
			if(rem.lisLen == 1) {
				results.add(rem.pathSoFar);
				continue;
			}
			
			for(int i = 0; i < rem.indx; i++) {
				if(lis[i] == rem.lisLen - 1 && nums[i] < rem.arrValue) {
					queue.add(new LISNode(i, rem.lisLen - 1, nums[i], nums[i] + "->" + rem.pathSoFar));
				}
			}
		}
		
		Collections.sort(results);

		return results;
	}

	public static void main(String[] args) {
		int[] nums = {52, 9, 11, 56, 23, 59, 18, 91, 28, 41, 1, 30, 14};
		List<String> results = printAllLis(nums);
		
		for(String result: results) {
			System.out.println(result);
		}
	}

}
