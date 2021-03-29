package practice.com.app.mathematics;

import java.util.Scanner;

//time complexity - O(log n)
public class TrailingZerosInFactorial {
    private static int countTrailingZeros(int n) {
        int res = 0;
        for(int i = 5; i <= n; i = i * 5) {
            res = res + (n / i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        int ans = countTrailingZeros(value);

        System.out.println(ans);

        scanner.close();
    }
}
