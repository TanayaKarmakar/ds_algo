package com.app.practice.strings;

import java.util.Scanner;

public class ReverseVowelsInAStringLeetcode345 {
    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    private static String reverseVowels(String s) {
        int len = s.length() - 1;
        int start = 0;
        int end = len;
        char[] sArr = s.toCharArray();
        while(start < end) {
            if(isVowel(sArr[start]) && isVowel(sArr[end])) {
                char tmp = sArr[start];
                sArr[start] = sArr[end];
                sArr[end] = tmp;
                start++;
                end--;
            } else if(!isVowel(sArr[start]))
                start++;
            else
                end--;
        }
        return new String(sArr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(reverseVowels(s));

        scanner.close();
    }
}
