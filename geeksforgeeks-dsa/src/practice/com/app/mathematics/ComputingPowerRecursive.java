package practice.com.app.mathematics;

import java.util.Scanner;

public class ComputingPowerRecursive {
    private static int power(int x, int n) {
        if(n == 0)
            return 1;
        int temp = power(x, n/2);
        temp = temp * temp;

        if(n % 2 == 0)
            return temp;
        else
            return temp * x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();

        int ans = power(x, n);

        System.out.println(ans);
        scanner.close();
    }
}
