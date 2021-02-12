package com.app.practice.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateIILeetCode219 {
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> list = entry.getValue();
            if(list.size() < 2)
                continue;
            for(int i = 1; i < list.size(); i++) {
                if(list.get(i) - list.get(i - 1) <= k)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;

        boolean ans = containsNearbyDuplicate(nums, k);

        System.out.println(ans);
    }
}
