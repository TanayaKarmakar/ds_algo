package practice.com.app.recursion;

import java.util.Scanner;

public class SumOfDigitsUsingRecursion {
    private static int sumOfDigits(int num) {
        if(num == 0)
            return 0;
        return (num % 10) + sumOfDigits(num / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int sum = sumOfDigits(num);

        System.out.println(sum);

        scanner.close();
    }
}
