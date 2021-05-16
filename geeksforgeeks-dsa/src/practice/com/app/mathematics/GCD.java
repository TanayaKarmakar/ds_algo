package practice.com.app.mathematics;

import java.util.Scanner;

public class GCD {
    private static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int ans = gcd(a, b);
        System.out.println(ans);
    }
}