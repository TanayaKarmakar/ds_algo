package practice.com.app.mathematics.assignment;

import java.util.Scanner;

public class DigitsInFactorial {
    private static int digitsInFactorial(int N){
        // code here
        double res = 0;
        for(int i = 1;i<=N;i++) {
            res += Math.log10(i);
        }

        return (int)Math.floor(res) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int count = digitsInFactorial(n);

        System.out.println(count);

        scanner.close();
    }
}
