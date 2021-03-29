package practice.com.app.mathematics;

import java.util.Scanner;

public class AllDivisorsOfANumber {
    private static void print(int n) {
        int i;
        for(i = 1; i * i <= n; i++) {
            if(n % i == 0)
                System.out.println(i);
        }

        for(;i >= 1; i--) {
            if(n % i == 0 && (n / i) != i)
                System.out.println((n / i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        print(n);

        scanner.close();
    }
}
