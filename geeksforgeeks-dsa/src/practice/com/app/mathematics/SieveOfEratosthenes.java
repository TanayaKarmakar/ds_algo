package practice.com.app.mathematics;

import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {
    private static void printSieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        for(int i = 2; i <= n; i++) {
            int k = i;
            int j = i * k;
            if(prime[i]) {
                while(j <= n) {
                    prime[j] = false;
                    k++;
                    j = i * k;
                }
            }
        }

        for(int i = 2; i <= n; i++) {
            if(prime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printSieve(n);

        scanner.close();
    }
}
