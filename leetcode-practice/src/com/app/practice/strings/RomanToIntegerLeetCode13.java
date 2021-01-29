package com.app.practice.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerLeetCode13 {
    private static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length();
        int sum = map.get(s.charAt(n - 1));

        for(int i = n - 2; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            int next = map.get(s.charAt(i + 1));
            if(curr < next) {
                sum -= curr;
            } else {
                sum += curr;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "III";

        int ans = romanToInt(s);
        System.out.println(ans);

        s = "MCMXCIV";
        ans = romanToInt(s);
        System.out.println(ans);

    }
}
