package com.app.practice.graphbfsdfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class JumpGameIVLeetcode1345 {
	private static int minJumps(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		int n = nums.length;
		for(int i = 0; i < n; i++) {
			if(!map.containsKey(nums[i])) {
				List<Integer> values = new ArrayList<>();
				values.add(i);
				map.put(nums[i], values);
			} else {
				map.get(nums[i]).add(i);
			}
		}
		
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		q.add(null);
		Set<Integer> visited = new HashSet<>();
		visited.add(0);
		
		while(!q.isEmpty()) {
			Integer curr = q.poll();
			
			if(curr == null) {
				if(q.peek() != null)
					q.add(null);
				count++;
				continue;
			}
			
			if(curr == n - 1)
				return count;
			
			if(curr - 1 >= 0 && !visited.contains(curr - 1)) {
				q.add(curr - 1);
				visited.add(curr - 1);
			}
			if(curr + 1 < n && !visited.contains(curr + 1)) {
				q.add(curr + 1);
				visited.add(curr + 1);
			}
			
			List<Integer> indices = map.get(nums[curr]);
			
			if(map.containsKey(nums[curr])) {
				for(Integer indx: indices) {
					if(!visited.contains(indx)) {
						q.add(indx);
						visited.add(indx);
					}
				}
				map.remove(nums[curr]);
			}
			
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int count = minJumps(nums);

		System.out.println(count);
		
		scanner.close();
	}

}
