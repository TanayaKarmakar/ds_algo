package com.app.practice.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ElementsMetadata {
    int freq;
    List<Integer> indices;

    public ElementsMetadata() {
        indices = new ArrayList<>();
    }
}

public class DegreeOfAnArrayLeetcode697 {
    private static int findShortestSubArray(int[] nums) {
        Map<Integer, ElementsMetadata> map = new HashMap<>();
        int maxFreq = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                ElementsMetadata mData = new ElementsMetadata();
                map.put(nums[i], mData);
            }
            map.get(nums[i]).freq++;
            map.get(nums[i]).indices.add(i);
            maxFreq = Integer.max(maxFreq, map.get(nums[i]).freq);
        }

        int len = nums.length;
        for(Map.Entry<Integer, ElementsMetadata> entry: map.entrySet()) {
            ElementsMetadata mData = entry.getValue();
            if(mData.freq == maxFreq) {
                int start = mData.indices.get(0);
                int end = mData.indices.get(mData.indices.size() - 1);
                len = Integer.min(len, end - start + 1);
            }
        }

        return len;
    }

    public static void main(String[] args) {

    }
}
