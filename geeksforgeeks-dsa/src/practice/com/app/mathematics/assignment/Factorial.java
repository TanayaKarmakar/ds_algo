package practice.com.app.mathematics.assignment;

import java.util.Scanner;

public class Factorial {
    private static long factorial(int N) {
        long result = 1;
        for(int i = 2; i <= N; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long ans = factorial(n);

        System.out.println(ans);

        scanner.close();
    }
}
