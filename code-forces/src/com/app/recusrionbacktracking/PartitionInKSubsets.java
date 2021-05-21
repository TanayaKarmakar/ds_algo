package com.app.recusrionbacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 18/05/21
 * @project competitive-programming
 */
public class PartitionInKSubsets {
    private static int counter = 0;

    private static void solution(int i, List<List<Integer>> sets, int ssf, int n, int k) {
        if(i > n) {
            if(ssf == k) {
                counter++;
                System.out.print(counter + ".");
                for(List<Integer> ans: sets) {
                    System.out.print(ans + " ");
                }
                System.out.println();
            }
            return;
        }

        for(int j = 0; j < sets.size(); j++) {
            if(sets.get(j).size() > 0) {
                sets.get(j).add(i);
                solution(i + 1, sets, ssf, n, k);
                sets.get(j).remove(sets.get(j).size() - 1);
            } else {
                sets.get(j).add(i);
                solution(i + 1, sets, ssf + 1, n, k);
                sets.get(j).remove(sets.get(j).size() - 1);
                break;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<List<Integer>> sets = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            sets.add(new ArrayList<>());
        }

        solution(1, sets, 0, n, k);
    }
}
