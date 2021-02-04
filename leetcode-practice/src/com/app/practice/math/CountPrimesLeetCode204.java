package com.app.practice.math;

import java.util.Arrays;
import java.util.Scanner;

public class CountPrimesLeetCode204 {
    private static int countPrimes(int n) {
        if(n <= 1)
            return 0;
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for(int i = 2; i * i < n; i++) {
            for(int j = i; j * i < n; j++) {
                if(primes[i * j])
                    primes[i * j] = false;
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(primes[i])
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(countPrimes(n));

        scanner.close();
    }
}
