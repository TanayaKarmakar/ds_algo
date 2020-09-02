package com.app.practice.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ContainsDuplicateIILeetcode219 {
	private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
        	if(!map.containsKey(nums[i])) {
        		List<Integer> values = new ArrayList<>();
        		values.add(i);
        		map.put(nums[i], values);
        	} else {
        		int prevIndx = map.get(nums[i])
        				.get(map.get(nums[i]).size() - 1);
        		if((i - prevIndx) <= k)
        			return true;
        		map.get(nums[i]).add(i);
        	}
        }
        
        return false;
    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int k = scanner.nextInt();
		
		boolean ans = containsNearbyDuplicate(nums, k);
		
		System.out.println(ans);
		
		scanner.close();
	}
}
