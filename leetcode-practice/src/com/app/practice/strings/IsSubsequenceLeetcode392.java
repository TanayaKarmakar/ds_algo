package com.app.practice.strings;

public class IsSubsequenceLeetcode392 {
    private static boolean isSubsequence(String s, String t) {
        if(s.length() == 0)
            return true;
        if(t.length() == 0)
            return false;
       int n = t.length();
       int m = s.length();

       int i = 0;
       int j = 0;

       while(i < m && j < n) {
           if(s.charAt(i) == t.charAt(j))
               i++;
           j++;
       }

       return i == s.length();
    }

    public static void main(String[] args) {

    }
}
