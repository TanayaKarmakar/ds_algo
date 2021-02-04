package com.app.practice.map;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberLeetCode202 {
    private static boolean isHappy(int n) {
        if(n == 1)
            return true;
        Set<Integer> set = new HashSet<>();

        int temp = n;

        while(true) {
            int sum = 0;
            while(temp != 0) {
                int r = temp % 10;
                sum += (r * r);
                temp = temp / 10;
            }
            if(sum == 1)
                return true;
            if(set.contains(sum))
                return false;
            set.add(sum);
            temp = sum;
        }
    }

    public static void main(String[] args) {

    }
}
