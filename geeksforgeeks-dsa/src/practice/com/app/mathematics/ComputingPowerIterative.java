package practice.com.app.mathematics;

import java.util.Scanner;

public class ComputingPowerIterative {
    private static int power(int x, int n) {
        int res = 1;
        int temp = x;
        while(n > 0) {
            if(n % 2 != 0) {
                res *= temp;
            }
            n = n / 2;
            temp = temp * x;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();

        int ans = power(x, n) ;
        System.out.println(ans);

        scanner.close();
    }
}
