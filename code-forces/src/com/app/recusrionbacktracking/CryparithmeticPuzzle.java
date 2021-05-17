package com.app.recusrionbacktracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author t0k02w6 on 17/05/21
 * @project competitive-programming
 */
public class CryparithmeticPuzzle {
    private static void buildUnique(String str, Map<Character, Integer> map, StringBuilder unique) {
        for(int i = 0; i < str.length(); i++) {
            if(!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), -1);
                unique.append(str.charAt(i));
            }
        }
    }

    private static int convertStringToNumber(String str, Map<Character, Integer> map) {
        int result = 0;
        for(int i = 0; i < str.length(); i++) {
            result = result * 10 + map.get(str.charAt(i));
        }
        return result;
    }


    private static void solution(String unique, Map<Character, Integer> map, int indx, boolean[] used,
                                 String s1, String s2, String s3) {
        if(indx == unique.length()) {
            //check for equal sum
            int n1 = convertStringToNumber(s1, map);
            int n2 = convertStringToNumber(s2, map);
            int n3 = convertStringToNumber(s3, map);
            if(n1 + n2 == n3) {
                for(Map.Entry<Character, Integer> entry: map.entrySet()) {
                    System.out.print(entry.getKey() + "-" + entry.getValue() + ":");
                }
                System.out.println();
            }
            return;
        }

        for(int i = 0; i < used.length; i++) {
            if(!used[i]) {
                map.put(unique.charAt(indx), i);
                used[i] = true;
                solution(unique, map, indx + 1, used, s1, s2, s3);
                map.put(unique.charAt(indx), -1);
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.next();
        String s2 = scanner.next();
        String s3 = scanner.next();

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder unique = new StringBuilder();
        buildUnique(s1, map, unique);
        buildUnique(s2, map, unique);
        buildUnique(s3, map, unique);

        boolean[] used = new boolean[10];
        solution(unique.toString(), map, 0, used, s1, s2, s3);
    }
}
