package com.app.questions.read;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class LongestContinuousSubArrayWithAbsoluteDiffLeetcode1438 {
	// Deque based solution
	// this is better as no sorting is involved
	private static int getMax2(int[] nums, int d) {
		Deque<Integer> maxD = new ArrayDeque<>();
		Deque<Integer> minD = new ArrayDeque<>();
		
		int i = 0;
		int n = nums.length;
		int j = 0;
		for(j = 0; j < n; j++) {
			while(!maxD.isEmpty() && maxD.peekLast() < nums[j])
				maxD.pollLast();
			while(!minD.isEmpty() && minD.peekLast() > nums[j])
				minD.pollLast();
			
			maxD.add(nums[j]);
			minD.add(nums[j]);
			if(maxD.peek() - minD.peek() > d) {
				if(maxD.peek() == nums[i])
					maxD.poll();
				if(minD.peek() == nums[i])
					minD.poll();
				i++;
			}
		}
		return (j - i);
	}

	
	//TreeMap based solution
	private static int getMax1(int[] nums, int d) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		int n = nums.length;
		
		int j = 0;
		int i = 0;
		for(i = 0; i < n; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			int min = map.firstEntry().getKey();
			int max = map.lastEntry().getKey();
			if(max - min > d) {
				map.put(nums[j], map.get(nums[j]) - 1);
				if(map.get(nums[j]) == 0)
					map.remove(nums[j]);
				j++;
			}
		}
		return (i - j);
	}

	public static void main(String[] args) {
		int[] nums = { 8, 2, 4, 7 };

		System.out.println("TreeMap based solution - " + getMax1(nums, 4));
		
		System.out.println("Deque based solution - " + getMax2(nums, 4));

		nums = new int[] { 10, 1, 2, 4, 7, 2 };
		
		System.out.println("TreeMap based solution - " + getMax1(nums, 5));
		
		System.out.println("Deque based solution - " + getMax2(nums, 5));
	}

}
