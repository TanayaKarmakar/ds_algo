package com.app.recusrionbacktracking;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author t0k02w6 on 21/05/21
 * @project competitive-programming
 */
public class WordPatternMatching {
    private static void solution(String pattern, String str, Map<Character, String> map, String originalPattern) {
        if(pattern.length() == 0) {
            if(str.length() == 0) {
                Set<Character> visited = new HashSet<>();
                for(int i = 0; i < originalPattern.length(); i++) {
                    char ch = originalPattern.charAt(i);
                    if(!visited.contains(ch)) {
                        System.out.print(ch + "->" + map.get(ch) + ", ");
                    }
                }
                System.out.print(".");
                System.out.println();
            }
            return;
        }

        char ch = pattern.charAt(0);
        String restOfPattern = pattern.substring(1);
        if(map.containsKey(ch)) {
            String previousMapping = map.get(ch);
            if(str.length() >= previousMapping.length()) {
                String current = str.substring(0, previousMapping.length());
                String right = str.substring(previousMapping.length());
                if(previousMapping.equals(current)) {
                    solution(restOfPattern, right, map, originalPattern);
                }
            }
        } else {
            for(int i = 0; i < str.length(); i++) {
                String left = str.substring(0, i + 1);
                String right = str.substring(i + 1);
                map.put(ch, left);
                solution(restOfPattern, right, map, originalPattern);
                map.remove(ch);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.next();
        String str = scanner.next();

        Map<Character, String> map = new HashMap<>();
        solution(pattern, str, map, pattern);

        scanner.close();
    }
}
