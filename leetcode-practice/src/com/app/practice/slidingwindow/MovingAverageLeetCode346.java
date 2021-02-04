package com.app.practice.slidingwindow;

import java.util.ArrayList;
import java.util.List;

class MovingAverage {
    private final int maxSize;
    private List<Integer> list;
    private int sum;


    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        maxSize = size;
        list = new ArrayList<>();
        sum = 0;
    }

    public double next(int val) {
        list.add(val);
        int n = list.size();
        sum += list.get(n - 1);
        int count = n;
        if(list.size() > maxSize) {
            sum -= list.get(n - maxSize - 1);
            count = maxSize;
        }
        return sum / (double)count;
    }
}

public class MovingAverageLeetCode346 {

    public static void main(String[] args) {
        MovingAverage obj = new MovingAverage(3);
        System.out.println(obj.next(1));
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));
    }
}
