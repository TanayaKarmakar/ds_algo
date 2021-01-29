package com.app.practice.map;

class CharValue {
    int indx;
    int freq;

    public CharValue(int indx, int freq) {
        this.indx = indx;
        this.freq = freq;
    }
}

public class NonRepeatingCharInStringLeetCode387 {
    private static int firstUniqChar(String s) {
        CharValue[] values = new CharValue[26];

        for(int i = 0; i < s.length(); i++) {
            int charIndx = s.charAt(i) - 'a';
            if(values[charIndx] == null) {
                CharValue cValue = new CharValue(i, 1);
                values[charIndx] = cValue;
            } else {
                values[charIndx].freq++;
            }
        }

        int indx = s.length();
        for(int i = 0; i < 26; i++) {
            if(values[i] != null) {
                if(values[i].freq == 1)
                    indx = Integer.min(indx, values[i].indx);
            }
        }

        return indx == s.length() ? -1: indx;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int indx = firstUniqChar(s);

        System.out.println(indx);

        s = "loveleetcode";
        indx = firstUniqChar(s);

        System.out.println(indx);
    }
}
