package practice.com.app.recursion;

import java.util.Scanner;

public class PrintNTo1 {
    private static void print(int n) {
        if(n == 0)
            return;
        System.out.println(n);
        print(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        print(num);

        scanner.close();
    }
}
