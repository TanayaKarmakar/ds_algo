package practice.com.app.recursion;

import java.util.Scanner;

public class Print1ToN {
    private static void print(int n) {
        if(n == 0)
            return;
        print(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        print(num);

        scanner.close();
    }
}
