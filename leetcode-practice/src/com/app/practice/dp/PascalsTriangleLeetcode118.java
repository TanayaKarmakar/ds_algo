package com.app.practice.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleLeetcode118 {
    private static List<List<Integer>> generate(int numRows) {
        if(numRows == 0)
            return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        list.add(l1);

        for(int i = 1; i < numRows; i++) {
            l1 = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i)
                    l1.add(1);
                else
                    l1.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            list.add(l1);
        }

        return list;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> list = generate(numRows);

        System.out.println(list);
    }
}
