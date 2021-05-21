package com.app.recusrionbacktracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author t0k02w6 on 19/05/21
 * @project competitive-programming
 */
public class PalindromicPermutation {
    private static void solution(Map<Character, Integer> map, int indx, int len, Character odd, String asf) {
        if(indx > len) {
            StringBuilder sb = new StringBuilder(asf);
            String rev = sb.reverse().toString();
            String res = asf;
            if(odd != null) {
                res += odd;
            }
            res += rev;
            System.out.println(res);
            return;
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() > 0) {
                int val = entry.getValue();
                map.put(entry.getKey(), val - 1);
                solution(map, indx + 1, len, odd, asf + entry.getKey());
                map.put(entry.getKey(), val);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Character odd = null;
        int oddCount = 0;
        int len = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                oddCount++;
                odd = entry.getKey();
            }
            map.put(entry.getKey(), entry.getValue() / 2);
            len += map.get(entry.getKey());
        }

        if(oddCount > 1) {
            System.out.println(-1);
            return;
        }

        solution(map, 1, len, odd, "");
    }
}
