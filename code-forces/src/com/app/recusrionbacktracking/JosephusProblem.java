package com.app.recusrionbacktracking;

import java.util.Scanner;

/**
 * @author t0k02w6 on 16/05/21
 * @project competitive-programming
 */
public class JosephusProblem {
    private static int jos(int n, int k) {
        if(n == 1)
            return 0;
        int small = jos(n - 1, k);
        return (small + k) % n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int ans = jos(n, k);
        System.out.println(ans);
    }
}
