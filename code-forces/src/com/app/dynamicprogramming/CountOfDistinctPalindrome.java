package com.app.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CountOfDistinctPalindrome {
    private static int count(String str) {
        int[][] dp = new int[str.length()][str.length()];

        int[] prev = new int[str.length()];
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!map.containsKey(ch)) {
                prev[i] = -1;
            } else {
                prev[i] = map.get(ch);
            }
            map.put(ch, i);
        }

        map.clear();

        int[] next = new int[str.length()];
        for(int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if(!map.containsKey(ch)) {
                next[i] = -1;
            } else {
                next[i] = map.get(ch);
            }
            map.put(ch, i);
        }

        for(int g = 0; g < dp.length; g++) {
            for(int i = 0, j = g; j < dp.length; i++, j++) {
                if(g == 0) {
                    dp[i][j] = 1;
                } else if(g == 1) {
                    dp[i][j] = 2;
                } else {
                    if(str.charAt(i) != str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    } else {
                        int nextOcc = next[i];
                        int prevOcc = prev[j];
                        if(nextOcc > prevOcc) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                        } else if(nextOcc == prevOcc) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                        } else {
                            dp[i][j] = 2 * dp[i + 1][j - 1] - dp[nextOcc + 1][prevOcc - 1];
                        }
                    }
                }
            }
        }

        return dp[0][dp.length - 1];
    }

    public static void main(String[] args) {

    }
}
