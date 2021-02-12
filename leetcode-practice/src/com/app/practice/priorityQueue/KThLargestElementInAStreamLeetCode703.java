package com.app.practice.priorityQueue;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> pQ = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        int len = Integer.min(k, nums.length);
        for(int i = 0; i < len; i++) {
            pQ.add(nums[i]);
        }

        for(int i = len; i < nums.length; i++) {
            if(nums[i] > pQ.peek()) {
                pQ.poll();
                pQ.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if(pQ.isEmpty() || pQ.size() < k) {
            pQ.add(val);
        } else {
            if(val > pQ.peek()) {
                pQ.poll();
                pQ.add(val);
            }
        }
        return pQ.peek();
    }
}

public class KThLargestElementInAStreamLeetCode703 {
    public static void main(String[] args) {
        KthLargest obj = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
}
