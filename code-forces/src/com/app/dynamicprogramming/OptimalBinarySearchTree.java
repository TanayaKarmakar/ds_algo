package com.app.dynamicprogramming;

public class OptimalBinarySearchTree {
    private static int getOptimalTree(int[] nodes, int[] searchFreq) {
        int[][] dp = new int[nodes.length][nodes.length];

        for(int g = 0; g < dp.length; g++) {
            for(int i = 0, j = g; j < dp.length; i++, j++) {
                if(g == 0) {
                    dp[i][j] = searchFreq[i];
                } else if(g == 1) {
                    int option1 = dp[i][j - 1] + 2 * dp[i + 1][j];
                    int option2 = 2 * dp[i][j - 1] + dp[i + 1][j];
                    dp[i][j] = Integer.min(option1, option2);
                } else {
                    int min = Integer.MAX_VALUE;
                    int totalCost = 0;
                    for(int k = i; k <= j; k++) {
                        totalCost += searchFreq[k];
                    }
                    for(int k = i; k <= j; k++) {
                        int currentCost = 0;
                        if(k > i) {
                            currentCost += dp[i][k - 1];
                        }
                        if(k < j) {
                            currentCost += dp[k + 1][j];
                        }
                        currentCost += totalCost;
                        min = Integer.min(min, currentCost);
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[0][dp.length - 1];
    }

    public static void main(String[] args) {
        int[] nodes = {10,20,30,40};
        int[] searchFreq = {3,1,2,1};

        int minCost = getOptimalTree(nodes, searchFreq);

        System.out.println("Min Cost - " + minCost);
    }
}
