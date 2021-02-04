package com.app.practice.strings;

public class ValidAnagramLeetCode242 {
    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];

        for(int i = 0; i < s.length(); i++) {
            int sIndx = s.charAt(i) - 'a';
            sFreq[sIndx]++;

            int tIndx = t.charAt(i) - 'a';
            tFreq[tIndx]++;
        }

        for(int i = 0; i < 26; i++) {
            if(sFreq[i] != tFreq[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}
