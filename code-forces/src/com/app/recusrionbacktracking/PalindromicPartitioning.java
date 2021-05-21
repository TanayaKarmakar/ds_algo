package com.app.recusrionbacktracking;

import java.util.Scanner;

/**
 * @author t0k02w6 on 19/05/21
 * @project competitive-programming
 */
public class PalindromicPartitioning {
    private static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static void solution(String str, String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);
            if(isPalindrome(prefix)) {
                String rest = str.substring(i + 1);
                solution(rest, asf + "(" + prefix + ") ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        solution(str, "");
    }
}
