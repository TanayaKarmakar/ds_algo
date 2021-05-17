package com.app.recusrionbacktracking;

import java.util.Scanner;

/**
 * @author t0k02w6 on 16/05/21
 * @project competitive-programming
 */
public class LexicographicOrderPrinting {
    private static void printLex(int start, int asf, int n) {
        if(asf > n)
            return;
        System.out.println(asf);
        for(int i = start; i <= 9; i++) {
            asf = asf * 10 + i;

            printLex(0, asf, n);
            asf = asf / 10;
        }
    }

    private static void print(int n) {
        printLex(1, 0, n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        print(n);
    }
}
