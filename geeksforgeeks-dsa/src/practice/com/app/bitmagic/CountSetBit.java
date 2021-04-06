package practice.com.app.bitmagic;

import java.util.Scanner;

public class CountSetBit {
    private static int countBits(int num) {
        int count = 0;
        while(num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int count = countBits(num);

        System.out.println(count);

        scanner.close();
    }
}
