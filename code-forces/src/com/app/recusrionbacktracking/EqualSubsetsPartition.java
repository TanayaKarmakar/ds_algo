package com.app.recusrionbacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 19/05/21
 * @project competitive-programming
 */
public class EqualSubsetsPartition {
    private static void solution(int[] nums, List<List<Integer>> sets, int ssf, int indx, int n, int k) {
        if(indx >= n) {
            if(ssf == k) {
                int[] sum = new int[k];
                int j = 0;
                for(List<Integer> set: sets) {
                    int res = set.stream().reduce(0, (el, subtotal) -> subtotal + el);
                    sum[j++] = res;
                }

                boolean flag = true;
                for(int i = 1; i < k; i++) {
                    if(sum[i - 1] != sum[i]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for (List<Integer> set : sets) {
                        System.out.print(set + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }

        for(int i = 0; i < sets.size(); i++) {
            if(sets.get(i).size() > 0) {
                sets.get(i).add(nums[indx]);
                solution(nums, sets, ssf, indx + 1, n, k);
                sets.get(i).remove(sets.get(i).size() - 1);
            } else {
                sets.get(i).add(nums[indx]);
                solution(nums, sets, ssf + 1, indx + 1, n, k);
                sets.get(i).remove(sets.get(i).size() - 1);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];

        int totalSum = 0;
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            totalSum += nums[i];
        }
        int k = scanner.nextInt();

        if(k > n || (totalSum % k != 0)) {
            System.out.println(-1);
            return;
        }

        List<List<Integer>> sets = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            sets.add(new ArrayList<>());
        }

        solution(nums, sets, 0, 0, n, k);

        scanner.close();
    }

}
