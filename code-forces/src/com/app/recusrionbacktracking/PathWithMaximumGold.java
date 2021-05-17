package com.app.recusrionbacktracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 16/05/21
 * @project competitive-programming
 */
public class PathWithMaximumGold {
    private static void findMax(int[][] path, boolean[][] visited, int i, int j, List<Integer> bag) {
        if(i < 0 || j < 0 || i >= path.length || j >= path[0].length || visited[i][j] || path[i][j] == 0)
            return;
        visited[i][j] = true;
        bag.add(path[i][j]);
        //top
        findMax(path, visited, i - 1, j, bag);

        //left
        findMax(path, visited, i, j - 1, bag);

        //right
        findMax(path, visited, i, j + 1, bag);

        //bottom
        findMax(path, visited, i + 1, j, bag);
    }

    private static int maxGold(int[][] path) {
        int m = path.length;
        int n = path[0].length;
        boolean[][] visited = new boolean[m][n];

        int result = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(path[i][j] != 0 && !visited[i][j]) {
                    List<Integer> bag = new ArrayList<>();
                    findMax(path, visited, i, j, bag);
                    int current = bag.stream().reduce(0, (subtotal, el) -> subtotal + el);
                    result = Integer.max(result, current);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] path = {{10,0,100,200,0,8,0},
                {20,0,0,0,0,6,0},
                {30,0,0,9,12,3,4},
                {40,0,2,5,8,3,11}
                ,{0,0,0,0,0,9,0},
                {5,6,7,0,7,4,2},
                {8,9,10,0,1,10,8}};

        int ans = maxGold(path);

        System.out.println(ans);
    }
}
