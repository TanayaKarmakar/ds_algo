package practice.com.app.bitmagic;

import java.util.Scanner;

public class PowerSetUsingBitWise {
    private static void printNumbers(String str) {
        int n = str.length();
        int pow = (int)Math.pow(2, n);
        for(int counter = 0; counter < pow; counter++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if((counter & (1 << j)) != 0) {
                    sb.append(str.charAt(j));
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        printNumbers(str);

        scanner.close();
    }
}
