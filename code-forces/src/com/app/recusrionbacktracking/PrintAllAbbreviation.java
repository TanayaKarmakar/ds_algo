package com.app.recusrionbacktracking;

import java.util.Scanner;

/**
 * @author t0k02w6 on 09/05/21
 * @project competitive-programming
 */
public class PrintAllAbbreviation {
    private static void printAbbr(String str, String asf, int count, int pos) {
        if(pos == str.length()) {
            if(count > 0) {
                System.out.println(asf + count);
            } else {
                System.out.println(asf);
            }
            return;
        }

        if(count > 0)
            printAbbr(str, asf + count + str.charAt(pos), 0, pos + 1);
        else
            printAbbr(str, asf + str.charAt(pos), 0, pos + 1);
        printAbbr(str, asf , count + 1, pos + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        printAbbr(str, "", 0, 0);
    }
}
