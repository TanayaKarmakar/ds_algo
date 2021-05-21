package com.app.recusrionbacktracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author t0k02w6 on 21/05/21
 * @project competitive-programming
 */
public class WordBreakProblem {
    private static void wordBreak(String longString, Set<String> wordSet, String asf) {
        if(longString.length() == 0) {
            System.out.println(asf);
            return;
        }

        for(int i = 0; i < longString.length(); i++) {
            String prefix = longString.substring(0, i + 1);
            if(wordSet.contains(prefix)) {
                String postFix = longString.substring(i + 1);
                wordBreak(postFix, wordSet, asf + prefix + "->");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String longString = scanner.next();

        int n = scanner.nextInt();
        Set<String> wordSet = new HashSet<>();
        for(int i = 0; i < n; i++) {
            String str = scanner.next();
            wordSet.add(str);
        }

        wordBreak(longString, wordSet, "");
        scanner.close();
    }
}
