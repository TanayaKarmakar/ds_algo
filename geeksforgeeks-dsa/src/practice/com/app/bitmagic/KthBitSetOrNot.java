package practice.com.app.bitmagic;

import java.util.Scanner;

public class KthBitSetOrNot {
    private static void setOrNot(int n,int k) {
        int mask = (1 << (k - 1));
        if((n & mask) != 0)
            System.out.println("Bit is set");
        else
            System.out.println("Bit is not set");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        setOrNot(n, k);

        scanner.close();
    }
}
