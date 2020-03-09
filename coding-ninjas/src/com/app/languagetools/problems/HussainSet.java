package com.app.languagetools.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HussainSet {
	private static void answerQueries(int[] nums, int []queries) {
		Arrays.sort(nums);
		
		int n = nums.length;
		int end = n - 1;
		
		int m = queries.length;
		int count = 1;
		int lastQuery = queries[m - 1];
		Queue<Integer> q = new LinkedList<>();
		
		int queryIndx = 0;
		int el = 0;
		while(count <= lastQuery) {
			if(end >= 0) {
				el = nums[end];
			}
			
			if(q.isEmpty() || el >= q.peek()) {
				end--;
			} else {
				el = q.poll();
			}
			if(queries[queryIndx] == count) {
				System.out.println(el);
				queryIndx++;
			}
			el = el/2;
			if(el > 0) {
				q.add(el);
			}
			count++;
			
		}
		
	}

	public static void main(String[] args) {
		int[] nums = { 8, 5, 3, 1 };
		int[] queries = { 1, 2, 3, 4, 6, 8 };
		answerQueries(nums, queries);
	}

}
