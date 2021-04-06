package practice.com.app.bitmagic;

import java.util.Scanner;

public class PowerOfTwo {
    private static boolean isPowerOfTwo(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        boolean ans = isPowerOfTwo(num);
        System.out.println(ans);

        scanner.close();
    }
}
