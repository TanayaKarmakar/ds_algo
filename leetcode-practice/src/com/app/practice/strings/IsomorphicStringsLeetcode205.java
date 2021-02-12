package com.app.practice.strings;

import java.util.Scanner;

public class IsomorphicStringsLeetcode205 {
    private static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] sFreq = new int[256];
        int[] tFreq = new int[256];
        int[] sIndx = new int[256];
        int[] tIndx = new int[256];

        for(int i = 0; i < s.length(); i++) {
            sFreq[s.charAt(i)]++;
            tFreq[t.charAt(i)]++;
            sIndx[s.charAt(i)] = i;
            tIndx[t.charAt(i)] = i;
        }

        for(int i = 0; i < s.length(); i++) {
            if(sFreq[s.charAt(i)] != tFreq[t.charAt(i)] || sIndx[s.charAt(i)] != tIndx[t.charAt(i)])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        boolean ans = isIsomorphic(s, t);
        System.out.println(ans);
    }
}
