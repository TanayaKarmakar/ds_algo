package com.app.practice.dp;

import java.util.Scanner;

public class ClimbingStairsLeetCode70 {
    private static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int ans = climbStairs(num);

        System.out.println(ans);

        scanner.close();
    }
}
