package com.app.practice.strings;

import java.util.Scanner;

public class RepeatedSubstringPatternLeetCode459 {
    private static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int j = 0;
        int i = 1;
        while(i < n) {
            if(s.charAt(j) == s.charAt(i)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        if(lps[n - 1] == 0)
            return false;
        int prefixLen = n - lps[n - 1];
        return n % prefixLen == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(repeatedSubstringPattern(str));

        scanner.close();
    }
}
