package com.app.recusrionbacktracking;

import java.util.Scanner;

/**
 * @author t0k02w6 on 15/05/21
 * @project competitive-programming
 */
public class MaximumScoreFormedByLetters {
    private static int solve(String[] words, int[] freqArr, int[] score, int indx) {
        if(indx == words.length)
            return 0;
        int notIncluded = solve(words, freqArr, score, indx + 1);
        String word = words[indx];
        boolean flag = true;
        int currentScore = 0;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(freqArr[ch - 'a'] == 0) {
                flag = false;
            }
            freqArr[ch - 'a']--;
            currentScore += score[ch - 'a'];
        }

        int included = 0;
        if(flag) {
            included = currentScore + solve(words, freqArr, score, indx + 1);
        }

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freqArr[ch - 'a']++;
        }

        return Integer.max(notIncluded, included);
    }


    private static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freqArr = new int[26];

        for(int i = 0; i < letters.length; i++) {
            freqArr[letters[i] - 'a']++;
        }

        return solve(words, freqArr, score, 0);
    }


    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int wordLen = scanner.nextInt();

        String[] words = new String[wordLen];
        for(int i = 0; i < wordLen; i++) {
            words[i] = scanner.nextLine();
        }

        int letterLen = scanner.nextInt();
        char[] letters = new char[letterLen];
        for(int i = 0; i < letterLen; i++) {
            letters[i] = scanner.next().charAt(0);
        }

        int[] score = new int[26];
        for(int i = 0; i < 26; i++) {
            score[i] = scanner.nextInt();
        }

        scanner.close();*/
        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};

        System.out.println(maxScoreWords(words, letters, score));
    }
}
