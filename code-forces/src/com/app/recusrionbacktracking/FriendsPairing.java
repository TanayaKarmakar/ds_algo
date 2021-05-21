package com.app.recusrionbacktracking;

import java.util.Scanner;

/**
 * @author t0k02w6 on 18/05/21
 * @project competitive-programming
 */
public class FriendsPairing {
    private static int count = 1;

    private static void solution(int i, boolean[] used, int n, String asf) {
        if(i > n) {
            System.out.println(count + "." + asf);
            count++;
            return;
        }

        if(used[i]) {
            solution(i + 1, used, n , asf);
        } else {
            used[i] = true;
            solution(i + 1, used, n, asf + "(" + i + ") ");
            for(int j = i + 1; j <= n; j++) {
                if(!used[j]) {
                    used[j] = true;
                    solution(i + 1, used, n, asf + "(" + i + j + ") ");
                    used[j] = false;
                }
            }
            used[i] = false;
        }
    }

    private static void printPossiblePairing(int n) {
        boolean[] used = new boolean[n + 1];
        solution(1, used, n, "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        printPossiblePairing(n);
    }
}
